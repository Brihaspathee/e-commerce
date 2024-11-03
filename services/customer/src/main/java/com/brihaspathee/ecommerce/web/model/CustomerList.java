package com.brihaspathee.ecommerce.web.model;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import lombok.Builder;

import java.util.List;

@Builder
public record CustomerList(
        List<Customer> customers
) {
}
