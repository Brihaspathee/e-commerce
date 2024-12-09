package com.brihaspathee.ecommerce.domain.repository;

import com.brihaspathee.ecommerce.domain.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 1:20 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
