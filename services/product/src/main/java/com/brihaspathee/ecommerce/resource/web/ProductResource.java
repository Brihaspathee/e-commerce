package com.brihaspathee.ecommerce.resource.web;

import com.brihaspathee.ecommerce.domain.entity.Product;
import com.brihaspathee.ecommerce.resource.model.ProductList;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseRequest;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseResponse;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;
import com.brihaspathee.ecommerce.services.interfaces.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, November 2024
 * Time: 5:54 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.resource.web
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductResource {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.create(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody
                                                                    List<ProductPurchaseRequest> productPurchaseRequests) {
        log.info("Product purchase: {}", productPurchaseRequests);
        return ResponseEntity.ok(productService.purchase(productPurchaseRequests));
    }

    @GetMapping
    public ResponseEntity<ProductList> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductList> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


}
