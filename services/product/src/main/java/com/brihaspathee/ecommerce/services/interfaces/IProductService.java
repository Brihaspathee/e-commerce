package com.brihaspathee.ecommerce.services.interfaces;

import com.brihaspathee.ecommerce.resource.model.ProductList;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseRequest;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseResponse;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;

import java.util.List;

public interface IProductService {

    Long create(ProductRequest productRequest);

    List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> productPurchaseRequests);

    ProductList getAllProducts();

    ProductList getProductById(Long id);
}
