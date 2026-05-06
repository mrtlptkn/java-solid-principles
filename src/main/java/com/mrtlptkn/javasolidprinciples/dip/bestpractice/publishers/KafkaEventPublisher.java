package com.mrtlptkn.javasolidprinciples.dip.bestpractice.publishers;

import com.mrtlptkn.javasolidprinciples.dip.bestpractice.IEventPublisher;

public class KafkaEventPublisher implements IEventPublisher
{

    @Override
    public void publishEvent(String event) {
        // Simulate publishing to Kafka
        System.out.println("Publishing event to Kafka: " + event);
    }
}
