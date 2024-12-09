package com.brihaspathee.ecommerce.domain.entity;

import com.brihaspathee.ecommerce.constants.NotificationType;
import com.brihaspathee.ecommerce.web.model.OrderConfirmation;
import com.brihaspathee.ecommerce.web.model.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 6:18 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    private String id;

    private NotificationType type;

    private LocalDateTime notificationDate;

    private OrderConfirmation orderConfirmation;

    private PaymentConfirmation paymentConfirmation;
}
