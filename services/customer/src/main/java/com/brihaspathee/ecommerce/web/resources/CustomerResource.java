package com.brihaspathee.ecommerce.web.resources;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import com.brihaspathee.ecommerce.services.interfaces.ICustomerService;
import com.brihaspathee.ecommerce.web.model.CustomerList;
import com.brihaspathee.ecommerce.web.model.CustomerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Long> createCustomer(@RequestBody @Valid CustomerRequest customer) {
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
    public ResponseEntity<CustomerList> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.existsById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }
}