package org.shelter.notificationservice.messagebroker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class MessageConfig {

    @Value("${notification.exchange.name}")
    private String notificationExchangeName;

    @Value("${notification.queue.name}")
    private String notificationQueueName;

    @Value("${notification.routing.key}")
    private String notificationRoutingKey;

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueueName);
    }

    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange(notificationExchangeName);
    }

    @Bean
    public Binding petBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(notificationExchange())
                .with(notificationRoutingKey);
    }
}
