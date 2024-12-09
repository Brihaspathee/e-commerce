package com.brihaspathee.ecommerce.services;

import com.brihaspathee.ecommerce.broker.producer.NotificationProducer;
import com.brihaspathee.ecommerce.domain.entity.Payment;
import com.brihaspathee.ecommerce.domain.repository.PaymentRepository;
import com.brihaspathee.ecommerce.mapper.PaymentMapper;
import com.brihaspathee.ecommerce.web.model.PaymentNotificationRequest;
import com.brihaspathee.ecommerce.web.model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:16 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.services
 * To change this template use File | Settings | File and Code Template
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    private final NotificationProducer notificationProducer;

    public Long createPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        notificationProducer.send(PaymentNotificationRequest.builder()
                        .paymentMethod(payment.getPaymentMethod())
                        .orderReference(paymentRequest.orderReference())
                        .amount(payment.getAmount())
                        .customerEmail(paymentRequest.customer().email())
                        .customerFirstName(paymentRequest.customer().firstName())
                        .customerLastName(paymentRequest.customer().lastName())
                .build());
        return payment.getPaymentId();
    }
}
