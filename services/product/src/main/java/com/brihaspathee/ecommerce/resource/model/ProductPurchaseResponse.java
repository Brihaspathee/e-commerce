package com.brihaspathee.ecommerce.resource.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductPurchaseResponse(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
