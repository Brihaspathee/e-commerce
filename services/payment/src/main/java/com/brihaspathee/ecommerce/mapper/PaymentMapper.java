package com.brihaspathee.ecommerce.mapper;

import com.brihaspathee.ecommerce.domain.entity.Payment;
import com.brihaspathee.ecommerce.web.model.PaymentRequest;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:25 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.mapper
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class PaymentMapper {

    public Payment toPayment(PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            return null;
        }
        Payment payment = Payment.builder()
                .paymentMethod(paymentRequest.paymentMethod())
                .paymentId(paymentRequest.paymentId())
                .amount(paymentRequest.amount())
                .orderId(paymentRequest.orderId())
                .build();
        return payment;
    }
}
