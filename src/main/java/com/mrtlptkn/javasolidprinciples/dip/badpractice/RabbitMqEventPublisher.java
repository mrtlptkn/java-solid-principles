package com.mrtlptkn.javasolidprinciples.dip.badpractice;

public class RabbitMqEventPublisher {

    public void publishEvent(String event) {
        System.out.println("Event published to RabbitMQ: " + event);
    }

}
