package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/25/24
 * Time: 6:13 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
