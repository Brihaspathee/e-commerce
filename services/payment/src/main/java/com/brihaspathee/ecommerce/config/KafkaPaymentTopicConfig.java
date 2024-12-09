package com.brihaspathee.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2024
 * Time: 8:38 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
public class KafkaPaymentTopicConfig {

    @Bean
    public NewTopic paymentsTopic() {
        return TopicBuilder.name("payment-topic").build();
    }
}
