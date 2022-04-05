package com.imhuis.code.examples.rabbitmq.config;

import com.imhuis.code.examples.rabbitmq.runner.RabbitAmqpTestRunner;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description:
 */
@Configuration
public class MessageConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    @Profile("!dev")
    public CommandLineRunner amqpTest() {
        return new RabbitAmqpTestRunner();
    }

}
