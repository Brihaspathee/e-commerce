package com.brihaspathee.ecommerce.web.resource;

import com.brihaspathee.ecommerce.service.OrderService;
import com.brihaspathee.ecommerce.web.model.OrderRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 6:24 PM
 * Project: OrderResource
 * Package Name: com.brihaspathee.ecommerce.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    public ResponseEntity<Long> createOrder(@RequestBody @Valid OrderRequest order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
