package com.mrtlptkn.javasolidprinciples.dip.bestpractice.publishers;

import com.mrtlptkn.javasolidprinciples.dip.bestpractice.IEventPublisher;

public class InMemoryEventPublisher implements IEventPublisher
{

    @Override
    public void publishEvent(String event) {
        // In-memory event publishing logic (e.g., storing events in a list)
        System.out.println("Event published: " + event);
    }
}
