package com.brihaspathee.ecommerce.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/25/24
 * Time: 6:14 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record OrderLineRequest(
        Long id,
        Long orderId,
        Long productId,
        double quantity
) { }
