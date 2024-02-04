package com.stannis.demokafkaproducer.interfaces;

import com.stannis.demokafkaproducer.dto.MyEvent;

public interface Event {

    // From the point of view of the application we want an interface to produce events to a generic messaging system.
    void produce(MyEvent event);
}
