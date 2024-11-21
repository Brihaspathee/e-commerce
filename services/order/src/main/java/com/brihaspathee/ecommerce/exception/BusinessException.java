package com.brihaspathee.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11/20/24
 * Time: 7:23 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.exception
 * To change this template use File | Settings | File and Code Template
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {}
}
