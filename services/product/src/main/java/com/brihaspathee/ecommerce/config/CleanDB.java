package com.brihaspathee.ecommerce.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, November 2024
 * Time: 5:47 AM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
@Profile("default")
public class CleanDB {

    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}
