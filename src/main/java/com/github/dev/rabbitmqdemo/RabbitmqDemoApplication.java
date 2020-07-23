package com.github.dev.rabbitmqdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDemoApplication {

    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitmqDemoApplication(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }

    // direct queue
    // @RabbitListener(queuesToDeclare = @Queue("queue-direct1"))
    public void directTest(String message) {
        System.out.println(message);
    }

    // work queue
    // @RabbitListener(queuesToDeclare = @Queue("queue-work"))
    public void workTest1(String message) {
        System.out.println("work1" + message);
    }

    // work queue
    // @RabbitListener(queuesToDeclare = @Queue("queue-work"))
    public void workTest2(String message) {
        System.out.println("work2" + message);
    }

    // fanout queue
    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "fanout-test", type = "fanout")
            )
    })*/
    public void fanoutTest(String message) {
        System.out.println("fanout1 " + message);
    }

    // fanout queue
    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "fanout-test", type = "fanout")
            )
    })*/
    public void fanoutTest2(String message) {
        System.out.println("fanout2 " + message);
    }

    // routing
    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routingTest", type = "direct"),
                    key = {"info"}
            )
    })*/
    public void routingTest(String message) {
        System.out.println("routing1 " + message);
    }

    // routing
    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routingTest", type = "direct"),
                    key = {"info", "error", "debug"}
            )
    })*/
    public void routingTest2(String message) {
        System.out.println("routing2 " + message);
    }

    // topic
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics", type = "topic"),
                    key = {"user.*"}
            )
    })
    public void topicTest1(String message) {
        System.out.println("topic1 " + message);
    }

    // routing
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics", type = "topic"),
                    key = {"user.hello"}
            )
    })
    public void topicTest2(String message) {
        System.out.println("topic2 " + message);
    }
}
