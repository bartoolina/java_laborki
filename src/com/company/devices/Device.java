package com.company.devices;

public abstract class Device {
    public final String producer;
    public final String model;
    public final int yearOfProduction;
    public Double value;

    public Device(String producer, String model, int yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public String toString() {

        return producer + " " + model;
    }

    public abstract void turnOn();
}
