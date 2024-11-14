package com.brihaspathee.ecommerce.services.impl;

import com.brihaspathee.ecommerce.domain.entity.Product;
import com.brihaspathee.ecommerce.domain.repository.ProductRepository;
import com.brihaspathee.ecommerce.exception.ProductNotFoundException;
import com.brihaspathee.ecommerce.exception.ProductPurchaseException;
import com.brihaspathee.ecommerce.mapper.ProductMapper;
import com.brihaspathee.ecommerce.resource.model.ProductList;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseRequest;
import com.brihaspathee.ecommerce.resource.model.ProductPurchaseResponse;
import com.brihaspathee.ecommerce.resource.model.ProductRequest;
import com.brihaspathee.ecommerce.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Long create(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        product = productRepository.save(product);
        return product.getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> productPurchaseRequests) {
        List<Long> productIds = productPurchaseRequests
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if(productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        List<ProductPurchaseRequest> storedRequests = productPurchaseRequests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<>();
        for(int i = 0; i < storedProducts.size(); i++) {
            Product storedProduct = storedProducts.get(i);
            ProductPurchaseRequest storedRequest = storedRequests.get(i);
            if(storedProduct.getAvailableQuantity() < storedRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock for product " + storedProduct.getName());
            }
            double remainingQuantity = storedProduct.getAvailableQuantity() - storedRequest.quantity();
            storedProduct.setAvailableQuantity(remainingQuantity);
            productRepository.save(storedProduct);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(storedProduct,
                    storedRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductList getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductList.builder()
                .products(products)
                .build();
    }

    @Override
    public ProductList getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () ->  new ProductNotFoundException("There is no product with id: " + id)
        );
        return ProductList.builder()
                .products(List.of(product))
                .build();
    }
}
