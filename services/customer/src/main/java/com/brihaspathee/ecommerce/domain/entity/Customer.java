package com.brihaspathee.ecommerce.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}
