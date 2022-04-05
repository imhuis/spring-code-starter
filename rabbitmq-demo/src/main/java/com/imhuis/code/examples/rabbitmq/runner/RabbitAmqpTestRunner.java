package com.imhuis.code.examples.rabbitmq.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description:
 */
public class RabbitAmqpTestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RabbitAmqpTestRunner run");
    }
}
