package com.brihaspathee.ecommerce.mapper;

import com.brihaspathee.ecommerce.domain.entity.Product;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    Product toProduct(ProductRequest productRequest) {
        if(productRequest == null) {
            return null;
        }
        return Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .build();
    }

}
