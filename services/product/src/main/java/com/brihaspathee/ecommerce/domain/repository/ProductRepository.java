package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIdInOrderById(List<Long> productIds);
}
