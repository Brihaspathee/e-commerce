package com.brihaspathee.ecommerce.domain.entity;

import lombok.Builder;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 1:17 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record Product(
        Long productId,

        String name,

        String description,

        BigDecimal price,

        double quantity
) {
}
