package com.brihaspathee.ecommerce.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2024
 * Time: 6:00 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
public record OrderLineResponse(
        Long orderLineId,
        double quantity
) {
}
