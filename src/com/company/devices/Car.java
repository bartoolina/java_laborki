package com.company.devices;

public class Car {
    public final String model;
    public final String producer;
    public final int yearOfProduction;
    public Double value;

    public Car(String producer, String model, int yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
    }

    public String toString() {

        return producer + model;
    }
}
