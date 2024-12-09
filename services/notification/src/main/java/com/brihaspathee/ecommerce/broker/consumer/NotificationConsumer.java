package com.brihaspathee.ecommerce.broker.consumer;

import com.brihaspathee.ecommerce.constants.NotificationType;
import com.brihaspathee.ecommerce.domain.entity.Notification;
import com.brihaspathee.ecommerce.web.model.OrderConfirmation;
import com.brihaspathee.ecommerce.web.model.PaymentConfirmation;
import com.brihaspathee.ecommerce.domain.repository.NotificationRepository;
import com.brihaspathee.ecommerce.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 1:22 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.broker.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;

     private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consumed payment confirmation: {}", paymentConfirmation);
        notificationRepository.save(Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                .build());
        // todo send email
        String customerName = paymentConfirmation.customerFirstName() + " " + paymentConfirmation.customerLastName();
        emailService.sendPaymentSuccessEmail(paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference());
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consumed order confirmation: {}", orderConfirmation);
        notificationRepository.save(Notification.builder()
                .type(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                .build());
        // todo send email
        String customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products());
    }
}
