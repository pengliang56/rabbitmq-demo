package com.github.dev.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public final static String DIRECT_NAME = "ysw-direct";

    @Bean
    Queue queue1(){
        return new Queue("queue-direct1");
    }

    @Bean

    Queue queue2(){
        return new Queue("queue-direct2");
    }

    @Bean
    Queue queue3(){
        return new Queue("queue-direct3");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_NAME, true,false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("direct1");
    }
}
