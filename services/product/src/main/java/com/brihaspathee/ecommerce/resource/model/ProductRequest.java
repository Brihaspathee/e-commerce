package com.brihaspathee.ecommerce.resource.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest(
        Long id,

        @NotNull(message="Product name is required")
        String name,

        @NotNull(message = "Product description is required")
        String description,

        @Positive(message = "Available quantity should be positive")
        double availableQuantity,

        @Positive(message = "Price should be positive")
        BigDecimal price,

        @NotNull(message = "Product category is mandatory")
        Long categoryId
) {
}