package com.brihaspathee.ecommerce.services.impl;

import com.brihaspathee.ecommerce.resource.model.ProductList;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseRequest;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseResponse;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;
import com.brihaspathee.ecommerce.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    @Override
    public Long create(ProductRequest productRequest) {
        return 0L;
    }

    @Override
    public ProductPurchaseResponse purchase(ProductPurchaseRequest productPurchaseRequest) {
        return null;
    }

    @Override
    public ProductList getAllProducts() {
        return null;
    }

    @Override
    public ProductList getProductById(Long id) {
        return null;
    }
}
