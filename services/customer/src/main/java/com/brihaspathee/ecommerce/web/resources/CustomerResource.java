package com.brihaspathee.ecommerce.web.resources;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.services.interfaces.ICustomerService;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    private final ICustomerService customerService;

//    @GetMapping("/test")
//    public ResponseEntity<String> getStringValue(){
//        log.info("Inside getStringValue");
//        return ResponseEntity.ok(test_variable);
//    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<CustomerList> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerList> getCustomer(@PathVariable String id) {
        log.info("Get customer with id {}", id);
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.existsById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }
}
