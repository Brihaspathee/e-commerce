package com.brihaspathee.ecommerce.service;

import com.brihaspathee.ecommerce.broker.producer.OrderProducer;
import com.brihaspathee.ecommerce.domain.entity.Order;
import com.brihaspathee.ecommerce.domain.repository.OrderRepository;
import com.brihaspathee.ecommerce.exception.BusinessException;
import com.brihaspathee.ecommerce.helper.impl.ProductClient;
import com.brihaspathee.ecommerce.helper.interfaces.CustomerClient;
import com.brihaspathee.ecommerce.helper.interfaces.PaymentClient;
import com.brihaspathee.ecommerce.mapper.OrderMapper;
import com.brihaspathee.ecommerce.web.model.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 6:27 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.service
 * To change this template use File | Settings | File and Code Template
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final OrderLineService orderLineService;

    private final OrderProducer orderProducer;

    private final PaymentClient paymentClient;

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderResponse).toList();
    }

    public OrderResponse getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return orderMapper.toOrderResponse(order.get());
        }else{
            throw new BusinessException("Order not found");
        }
    }

    @Transactional
    public Long createOrder(OrderRequest orderRequest) {
        // check the customer --> Open Feign

        Optional<CustomerList> optionalCustomerList =
                this.customerClient.findCustomerById(orderRequest.customerId());
        if(optionalCustomerList.isEmpty() ||
                optionalCustomerList.get().customers().isEmpty()){
            throw new BusinessException("Cannot create order, no customer exists");
        }

        // purchase the product -> using product micro service (Rest Template)
        List<PurchaseResponse> purchaseResponses =
                productClient.purchaseProducts(orderRequest.products());

        // persist order
        Order order = orderMapper.toOrder(orderRequest);
        orderRepository.save(order);

        // persist order lines
        for(PurchaseRequest purchaseRequest: orderRequest.products()){
            orderLineService.save(OrderLineRequest.builder()
                            .orderId(order.getId())
                            .productId(purchaseRequest.productId())
                            .quantity(purchaseRequest.quantity())
                    .build());
        }

        // start payment process
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .amount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .orderId(order.getId())
                .orderReference(order.getReference())
                .customer(optionalCustomerList.get().customers().getFirst())
                .build();
        paymentClient.requestOrderPayment(paymentRequest);

        // send the order confirmation to notification service
        orderProducer.sendOrderConfirmation(OrderConfirmation.builder()
                .orderReference(orderRequest.reference())
                        .totalAmount(orderRequest.amount())
                        .paymentMethod(orderRequest.paymentMethod())
                        .customer(optionalCustomerList.get().customers().getFirst())
                        .products(purchaseResponses)
                .build());
        return order.getId();
    }
}
