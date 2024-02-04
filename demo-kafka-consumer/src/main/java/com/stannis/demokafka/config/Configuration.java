package com.stannis.demokafka.config;

import com.stannis.demokafka.dto.MyEvent;
import com.stannis.demokafka.interfaces.EventConsumer;
import com.stannis.demokafka.services.MyStreamEventConsumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public EventConsumer myEventConsumer() {
        return new EventConsumer() {
            @Override
            public void consume(MyEvent event) {
                System.out.println("Received " + event.text());
            }
        };
    }

    @Bean(name = "my-consumer")
    public EventConsumer myStreamEventConsumerFunction(@Qualifier("myEventConsumer") EventConsumer consumer) {
        return new MyStreamEventConsumer(consumer);
    }

}
