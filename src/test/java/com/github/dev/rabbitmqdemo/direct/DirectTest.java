package com.github.dev.rabbitmqdemo.direct;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DirectTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void testDirect() {
        String message = "direct-task";
        amqpTemplate.convertAndSend("queue-direct1", message);
    }
}
