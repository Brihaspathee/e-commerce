package com.brihaspathee.ecommerce.resource.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductPurchaseRequest(
        @NotNull(message = "Product id is mandatory")
        Long productId,

        @NotNull(message = "Quantity is mandatory")
        double quantity
) {
}
