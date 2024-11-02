package com.brihaspathee.ecommerce.services.impl;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.domain.repository.CustomerRepository;
import com.brihaspathee.ecommerce.mapper.CustomerMapper;
import com.brihaspathee.ecommerce.services.interfaces.ICustomerService;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Long createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer = customerRepository.save(customer);
        return customer.getId();
    }
}
