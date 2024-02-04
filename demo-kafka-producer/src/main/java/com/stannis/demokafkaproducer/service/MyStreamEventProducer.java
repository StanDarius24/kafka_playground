package com.stannis.demokafkaproducer.service;

import com.stannis.demokafkaproducer.dto.MyEvent;
import com.stannis.demokafkaproducer.dto.MyEventPayload;
import com.stannis.demokafkaproducer.interfaces.Event;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;


public class MyStreamEventProducer implements Supplier<Flux<MyEventPayload>>, Event {

    private final Sinks.Many<MyEventPayload> sink = Sinks.many().unicast().onBackpressureBuffer();


    @Override
    public Flux<MyEventPayload> get() {
        return sink.asFlux();
    }

    @Override
    public void produce(MyEvent event) {
        var message = MessageBuilder
                .withPayload(toPayload(event))
                .setHeader(KafkaHeaders.KEY, toKey(event))
                .build();
        sink.emitNext(message.getPayload(), FAIL_FAST);
    }

    private MyEventPayload toPayload(MyEvent event) {
        return new MyEventPayload(event.text(), event.text().length());
    }

    private String toKey(MyEvent event) {
        return "key" + event.text().length();
    }
}
