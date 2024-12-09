package com.brihaspathee.ecommerce.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 7:13 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record Customer(
        String id,

        String firstName,

        String lastName,

        String email
) {
}
