package com.company.devices;

public class Phone {
    final String producer;
    final String model;

    public Phone(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    public String toString() {
        return producer + " " + model;
    }
}
