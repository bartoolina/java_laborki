package com.company.devices;

public class Phone extends Device {

    public Phone(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("The phone is on now.");
    }
}
