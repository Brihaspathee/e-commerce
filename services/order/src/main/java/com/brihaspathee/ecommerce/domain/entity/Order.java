package com.brihaspathee.ecommerce.domain.entity;

import com.brihaspathee.ecommerce.constants.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 17, November 2024
 * Time: 7:08 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String reference;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @CreatedDate
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;


}
