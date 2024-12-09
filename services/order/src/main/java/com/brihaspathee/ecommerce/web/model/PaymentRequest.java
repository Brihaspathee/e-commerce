package com.brihaspathee.ecommerce.web.model;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2024
 * Time: 9:02 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record PaymentRequest (
        Long paymentId,

        BigDecimal amount,

        PaymentMethod paymentMethod,

        Long orderId,

        String orderReference,

        Customer customer
) {
}
