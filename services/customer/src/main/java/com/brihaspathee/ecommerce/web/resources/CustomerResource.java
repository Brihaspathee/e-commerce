package com.brihaspathee.ecommerce.web.resources;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.services.interfaces.ICustomerService;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Long> createCustomer(@RequestBody CustomerRequest customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }
}
