package com.company.devices;

import com.company.Human;
import com.company.Sellable;

public class Car extends Device implements Sellable {
    public Double value;

    public Car(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Engine is on.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        Car carSell = seller.getCar();
        if (carSell != null && carSell.equals(this)) {
            if (buyer.setCar(this, price)) {
                System.out.println(buyer + " bought a " + this + " from " + seller);

                seller.setCar(null, 0.0);
                seller.cash += price;
            } else {
                System.out.println("The transaction has not taken place");
            }
        } else {
            System.out.println(seller + " can't sell not his car.");
        }
    }
}
