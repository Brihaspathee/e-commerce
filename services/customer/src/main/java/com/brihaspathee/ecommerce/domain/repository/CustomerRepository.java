package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
