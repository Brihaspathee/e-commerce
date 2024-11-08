package com.brihaspathee.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 07, November 2024
 * Time: 3:51 PM
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
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
