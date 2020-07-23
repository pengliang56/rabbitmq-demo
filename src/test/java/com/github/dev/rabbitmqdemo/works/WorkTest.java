package com.github.dev.rabbitmqdemo.works;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void testWork() {
        String message = "testWork";
        amqpTemplate.convertAndSend("queue-work", "testWork111");
        System.out.println("1");
        amqpTemplate.convertAndSend("queue-work", "testWork222");
        System.out.println("2");
        amqpTemplate.convertAndSend("queue-work", "testWork33");
        System.out.println("3");
        amqpTemplate.convertAndSend("queue-work", "testWork444");
        System.out.println("4");
    }
}
