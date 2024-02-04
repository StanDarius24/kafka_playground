package com.stannis.demokafkaproducer.dto;

public record MyEventPayload(
        String string,
        Integer integer
) {}
