package com.brihaspathee.ecommerce.handler;

import lombok.Builder;

import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 5:50 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.handler
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record ErrorResponse(
        Map<String, String> errors
) {
}
