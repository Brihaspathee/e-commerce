package com.brihaspathee.ecommerce.helper.interfaces;

import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2024
 * Time: 8:56 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.helper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@FeignClient(
        name="payment-service",
        url="${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequest paymentRequest);
}
