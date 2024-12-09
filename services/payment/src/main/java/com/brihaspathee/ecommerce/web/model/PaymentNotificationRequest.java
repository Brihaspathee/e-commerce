package com.brihaspathee.ecommerce.web.model;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2024
 * Time: 8:41 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record PaymentNotificationRequest(
      String orderReference,
      BigDecimal amount,
      PaymentMethod paymentMethod,
      String customerFirstName,
      String customerLastName,
      String customerEmail
) {
}
