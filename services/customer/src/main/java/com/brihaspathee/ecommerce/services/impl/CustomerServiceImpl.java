package com.brihaspathee.ecommerce.services.impl;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.domain.repository.CustomerRepository;
import com.brihaspathee.ecommerce.exception.CustomerNotFoundException;
import com.brihaspathee.ecommerce.mapper.CustomerMapper;
import com.brihaspathee.ecommerce.services.interfaces.ICustomerService;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.List;

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

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer with id: " + customerRequest.id()
                + " not found"));
        mergeCustomer(customer, customerRequest);
        customer = customerRepository.save(customer);
    }

    @Override
    public CustomerList getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return CustomerList.builder()
                .customers(customers)
                .build();
    }

    @Override
    public CustomerList getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " not found"));
        return CustomerList.builder()
                .customers(List.of(customer))
                .build();
    }

    @Override
    public Boolean existsById(Long id) {
        return customerRepository.findById(id).isPresent();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest) {
        if(StringUtils.isNotBlank(customerRequest.firstName())) {
            customer.setFirstName(customerRequest.firstName());
        }
        if(StringUtils.isNotBlank(customerRequest.lastName())) {
            customer.setLastName(customerRequest.lastName());
        }
        if(StringUtils.isNotBlank(customerRequest.email())) {
            customer.setEmail(customerRequest.email());
        }
        if(customerRequest.address() != null) {
            customer.setAddress(customerRequest.address());
        }
    }


}
