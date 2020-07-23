package com.github.dev.rabbitmqdemo.routing;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoutingTest {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void testRouting() {
        amqpTemplate.convertAndSend("routingTest", "info", "test-routing-message-info");
        amqpTemplate.convertAndSend("routingTest", "error", "test-routing-message-error");
    }
}
