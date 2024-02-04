package com.stannis.demokafka.services;

import com.stannis.demokafka.dto.MyEvent;
import com.stannis.demokafka.dto.MyEventPayload;
import com.stannis.demokafka.interfaces.EventConsumer;

import java.util.function.Supplier;

public class MyStreamEventConsumer implements Supplier<MyEventPayload>, EventConsumer {

    private final EventConsumer eventConsumer;

    public MyStreamEventConsumer(EventConsumer eventConsumer) {
        this.eventConsumer = eventConsumer;
    }

    @Override
    public MyEventPayload get() {
        eventConsumer.consume(new MyEvent("Test"));
        return new MyEventPayload("Test", 4);
    }

    @Override
    public void consume(MyEvent event) {
        this.eventConsumer.consume(event);
    }

}
