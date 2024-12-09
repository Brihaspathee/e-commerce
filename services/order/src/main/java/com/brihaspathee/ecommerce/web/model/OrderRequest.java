package com.brihaspathee.ecommerce.web.model;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 6:29 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record OrderRequest (
        Long id,

        String reference,

        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method cannot be null")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer should be present")
        @NotBlank(message = "Customer id cannot be blank")
        String customerId,

        @NotEmpty(message = "Products cannot be empty")
        List<PurchaseRequest> products
) {
}
