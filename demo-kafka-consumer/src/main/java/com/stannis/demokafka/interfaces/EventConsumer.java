package com.stannis.demokafka.interfaces;


import com.stannis.demokafka.dto.MyEvent;

public interface EventConsumer {

    void consume(MyEvent event);

}
