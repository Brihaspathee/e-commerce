package com.brihaspathee.ecommerce.services.interfaces;

import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    Long createCustomer(CustomerRequest customerRequest);
}
