package com.brihaspathee.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 28, November 2024
 * Time: 5:41 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
public class KafkaOrderConfig {

    @Bean
    public NewTopic ordersTopic() {
        return TopicBuilder
                .name("order-topic")
                .build();
    }
}
