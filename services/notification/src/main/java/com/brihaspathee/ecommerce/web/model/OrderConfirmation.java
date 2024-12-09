package com.brihaspathee.ecommerce.web.model;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.domain.entity.Product;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 1:13 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
