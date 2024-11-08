package com.brihaspathee.ecommerce.services.interfaces;

import com.brihaspathee.ecommerce.resource.model.ProductList;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseRequest;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseResponse;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;

public interface IProductService {

    Long create(ProductRequest productRequest);

    ProductPurchaseResponse purchase(ProductPurchaseRequest productPurchaseRequest);

    ProductList getAllProducts();

    ProductList getProductById(Long id);
}
