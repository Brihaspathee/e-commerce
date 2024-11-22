package com.brihaspathee.ecommerce.helper.impl;

import com.brihaspathee.ecommerce.exception.BusinessException;
import com.brihaspathee.ecommerce.web.model.PurchaseRequest;
import com.brihaspathee.ecommerce.web.model.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 7:26 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.helper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productURL;

    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> purchaseRequests){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> httpEntity =
                new HttpEntity<>(purchaseRequests, httpHeaders);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
          productURL + "/purchase",
                HttpMethod.POST,
                httpEntity,
                responseType
        );
        if(responseEntity.getStatusCode().isError()){
            throw new BusinessException("An error occured while accessing the product " + responseEntity.getStatusCode() );
        }
        return responseEntity.getBody();

    }

}
