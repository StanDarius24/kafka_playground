package com.stannis.demokafkaproducer.config;

import com.stannis.demokafkaproducer.dto.MyEventPayload;
import com.stannis.demokafkaproducer.service.MyStreamEventProducer;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    MyStreamEventProducer myStreamEventProducer() {
        return new MyStreamEventProducer();
    }

    @Bean("my-producer")
    Supplier<Flux<MyEventPayload>> myStreamEventProducerFunction(MyStreamEventProducer streamEventProducer) {
        return streamEventProducer;
    }

}
