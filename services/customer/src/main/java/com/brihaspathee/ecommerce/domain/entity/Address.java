package com.brihaspathee.ecommerce.domain.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
