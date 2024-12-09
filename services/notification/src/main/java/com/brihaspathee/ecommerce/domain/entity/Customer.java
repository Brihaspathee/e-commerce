package com.brihaspathee.ecommerce.domain.entity;

import lombok.Builder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 1:16 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record Customer(
        String customerId,
        String firstName,
        String lastName,
        String email
) {
}
