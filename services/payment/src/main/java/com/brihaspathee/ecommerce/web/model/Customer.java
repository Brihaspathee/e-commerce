package com.brihaspathee.ecommerce.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:20 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
@Validated
public record Customer(

      String customerId,
      @NotNull(message = "First name is required")
      String firstName,
      @NotNull(message = "Last name is required")
      String lastName,
      @NotNull(message = "Email is required")
      @Email(message = "Email is invalid")
      String email
) {
}
