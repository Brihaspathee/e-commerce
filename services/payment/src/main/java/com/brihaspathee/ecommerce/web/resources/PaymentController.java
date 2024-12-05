package com.brihaspathee.ecommerce.web.resources;

import com.brihaspathee.ecommerce.services.PaymentService;
import com.brihaspathee.ecommerce.web.model.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:14 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.resources
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> createPayment(@RequestBody @Valid
                                                  PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));

    }
}
