package com.brihaspathee.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 17, November 2024
 * Time: 7:15 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private Order order;

    private Long productId;

    private double quantity;


}
