package com.github.dev.rabbitmqdemo.fanout;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FanoutTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void testWork() {
        amqpTemplate.convertAndSend("fanout-test", "", "test-fanout-message");
    }
}
