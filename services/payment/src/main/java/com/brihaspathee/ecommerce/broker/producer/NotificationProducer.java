package com.brihaspathee.ecommerce.broker.producer;

import com.brihaspathee.ecommerce.web.model.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2024
 * Time: 8:40 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.broker.producer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

    public void send( PaymentNotificationRequest message) {
        Message<PaymentNotificationRequest> notificationRequestMessage = MessageBuilder
                .withPayload(message)
                        .setHeader(KafkaHeaders.TOPIC, "payment-topic").build();
        kafkaTemplate.send(notificationRequestMessage);
    }
}
