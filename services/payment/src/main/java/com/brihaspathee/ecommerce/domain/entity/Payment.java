package com.brihaspathee.ecommerce.domain.entity;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12/4/24
 * Time: 6:01 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Long orderId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;
}
