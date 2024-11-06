package com.brihaspathee.ecommerce.services.interfaces;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    Long createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    CustomerList getAllCustomers();

    CustomerList getCustomerById(Long id);

    Boolean existsById(Long id);

    void deleteCustomer(Long id);
}
