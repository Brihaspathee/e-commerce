package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:24 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
