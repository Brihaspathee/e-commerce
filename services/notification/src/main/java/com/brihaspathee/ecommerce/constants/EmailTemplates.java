package com.brihaspathee.ecommerce.constants;

import lombok.Getter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 2:15 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.constants
 * To change this template use File | Settings | File and Code Template
 */
public enum EmailTemplates {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Order confirmation");

    @Getter
    private final String template;

    @Getter
    private final String subject;

    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
