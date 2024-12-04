package com.brihaspathee.ecommerce.mapper;

import com.brihaspathee.ecommerce.domain.entity.Order;
import com.brihaspathee.ecommerce.domain.entity.OrderLine;
import com.brihaspathee.ecommerce.web.model.OrderLineRequest;
import com.brihaspathee.ecommerce.web.model.OrderLineResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/25/24
 * Time: 6:20 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.mapper
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        if(orderLineRequest == null) {
            return null;
        }
        OrderLine orderLine = OrderLine.builder()
                .id(orderLineRequest.id())
                .order(Order.builder()
                        .id(orderLineRequest.orderId())
                        .build())
                .productId(orderLineRequest.productId())
                .quantity(orderLineRequest.quantity())
                .build();
        return orderLine;
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        if(orderLine == null) {
            return null;
        }
        OrderLineResponse orderLineResponse = OrderLineResponse.builder()
                .orderLineId(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
        return orderLineResponse;
    }
}
