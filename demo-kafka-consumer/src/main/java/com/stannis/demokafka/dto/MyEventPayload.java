package com.stannis.demokafka.dto;

public record MyEventPayload(
        String string,
        Integer integer
) {}
