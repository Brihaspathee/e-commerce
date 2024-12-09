package com.brihaspathee.ecommerce.services.interfaces;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    String createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    CustomerList getAllCustomers();

    CustomerList getCustomerById(String id);

    Boolean existsById(String id);

    void deleteCustomer(String id);
}
