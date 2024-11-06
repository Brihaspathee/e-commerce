package com.brihaspathee.ecommerce.handler;

import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, November 2024
 * Time: 3:42 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.handler
 * To change this template use File | Settings | File and Code Template
 */
public record ErrorResponse (
        Map<String, String> errors
) { }
