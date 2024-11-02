package com.brihaspathee.ecommerce.mapper;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }
}
