package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/22/24
 * Time: 5:49 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
