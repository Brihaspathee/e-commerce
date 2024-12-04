package com.brihaspathee.ecommerce.web.resource;

import com.brihaspathee.ecommerce.service.OrderLineService;
import com.brihaspathee.ecommerce.web.model.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2024
 * Time: 5:57 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineResource {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findById(@PathVariable("order-id") Long orderId) {
        return ResponseEntity.ok(orderLineService.getOrderLinesOfOrder(orderId));
    }
}
