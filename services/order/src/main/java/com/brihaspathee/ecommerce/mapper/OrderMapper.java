package com.brihaspathee.ecommerce.mapper;

import com.brihaspathee.ecommerce.domain.entity.Order;
import com.brihaspathee.ecommerce.web.model.OrderRequest;
import com.brihaspathee.ecommerce.web.model.OrderResponse;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 6:59 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.mapper
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }
        Order order = Order.builder()
                .id(orderRequest.id())
                .customerId(orderRequest.customerId())
                .reference(orderRequest.reference())
                .totalAmount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
        return order;
    }

    public OrderResponse toOrderResponse(Order order) {
        if (order == null) {
            return null;
        }
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .reference(order.getReference())
                .amount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .build();
        return orderResponse;
    }
}
