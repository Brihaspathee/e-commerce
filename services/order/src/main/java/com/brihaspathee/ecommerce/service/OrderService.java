package com.brihaspathee.ecommerce.service;

import com.brihaspathee.ecommerce.domain.entity.Order;
import com.brihaspathee.ecommerce.domain.repository.OrderRepository;
import com.brihaspathee.ecommerce.exception.BusinessException;
import com.brihaspathee.ecommerce.helper.impl.ProductClient;
import com.brihaspathee.ecommerce.helper.interfaces.CustomerClient;
import com.brihaspathee.ecommerce.mapper.OrderMapper;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Long createOrder(OrderRequest orderRequest) {
        // check the customer --> Open Feign

        Optional<CustomerList> optionalCustomerList =
                this.customerClient.findCustomerById(Long.valueOf(orderRequest.customerId()));
        if(optionalCustomerList.isEmpty() ||
                optionalCustomerList.get().customers().isEmpty()){
            throw new BusinessException("Cannot create order, no customer exists");
        }

        // purchase the product -> using product micro service (Rest Template)
        productClient.purchaseProducts(orderRequest.products());

        // persist order
        Order order = orderMapper.toOrder(orderRequest);
        orderRepository.save(order);


        // persist order lines

        // start payment process

        // send the order confirmation to notification service
    }
}
