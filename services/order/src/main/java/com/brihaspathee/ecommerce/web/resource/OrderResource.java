package com.brihaspathee.ecommerce.web.resource;

import com.brihaspathee.ecommerce.service.OrderService;
import com.brihaspathee.ecommerce.web.model.OrderRequest;
import com.brihaspathee.ecommerce.web.model.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody @Valid OrderRequest order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("order-id") Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
