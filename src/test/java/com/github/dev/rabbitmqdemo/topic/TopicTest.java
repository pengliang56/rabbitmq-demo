package com.github.dev.rabbitmqdemo.topic;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void testRouting() {
        amqpTemplate.convertAndSend("topics", "user.save", "test-topic-message-save");
        amqpTemplate.convertAndSend("topics", "user.hello", "test-topic-message-hello");
    }
}
