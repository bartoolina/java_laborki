package com.company;

public class Car {
    final String model;
    final String producer;
    final int yearOfProduction;

    public Car(String producer, String model, int yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
    }
}
