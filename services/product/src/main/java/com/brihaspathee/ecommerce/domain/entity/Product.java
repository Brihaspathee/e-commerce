package com.brihaspathee.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 07, November 2024
 * Time: 3:50 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private double availableQuantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
