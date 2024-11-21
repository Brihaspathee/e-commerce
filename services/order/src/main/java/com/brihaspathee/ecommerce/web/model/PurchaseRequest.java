package com.brihaspathee.ecommerce.web.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 6:54 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
public record PurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Long productId,

        @Positive(message = "Quantity has to be positive")
        double quantity
) {
}
