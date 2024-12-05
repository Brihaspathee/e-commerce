package com.brihaspathee.ecommerce.services;

import com.brihaspathee.ecommerce.domain.entity.Payment;
import com.brihaspathee.ecommerce.domain.repository.PaymentRepository;
import com.brihaspathee.ecommerce.mapper.PaymentMapper;
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

    public Long createPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        return payment.getPaymentId();
    }
}
