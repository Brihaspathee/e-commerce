package com.brihaspathee.ecommerce.service;

import com.brihaspathee.ecommerce.domain.entity.OrderLine;
import com.brihaspathee.ecommerce.domain.repository.OrderLineRepository;
import com.brihaspathee.ecommerce.mapper.OrderLineMapper;
import com.brihaspathee.ecommerce.web.model.OrderLineRequest;
import com.brihaspathee.ecommerce.web.model.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/25/24
 * Time: 6:12 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.service
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    public Long save(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = orderLineRepository
                .save(
                        orderLineMapper.toOrderLine(orderLineRequest));
        return orderLine.getId();
    }

    public List<OrderLineResponse> getOrderLinesOfOrder(Long orderId){
        return orderLineRepository.findByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .toList();
    }
}
