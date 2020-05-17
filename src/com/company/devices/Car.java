package com.company.devices;

public class Car extends Device {
    public Double value;

    public Car(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Engine is on.");
    }
}
