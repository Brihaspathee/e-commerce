package com.brihaspathee.ecommerce.resource.model;

import com.brihaspathee.ecommerce.domain.entity.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductList(
        List<Product> products
) {
}
