package com.brihaspathee.ecommerce.helper.interfaces;

import com.brihaspathee.ecommerce.web.model.CustomerList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 7:02 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.helper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@FeignClient(
        name="customer-service",
        url="${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{id}")
    Optional<CustomerList> findCustomerById(@PathVariable("id") String customerId);
}
