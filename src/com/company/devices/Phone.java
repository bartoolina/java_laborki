package com.company.devices;

import com.company.Human;
import com.company.salleable;

public class Phone extends Device implements salleable {

    public Phone(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("The phone is on now.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        Phone phoneSell = seller.phone;
        if (phoneSell != null && phoneSell.equals(this)) {
            if (buyer.cash >= price) {
                System.out.println(buyer + "bought a " + this + " from " + seller);
                buyer.phone = this;
                buyer.cash -= price;
                seller.phone = null;
                seller.cash += price;
            } else {
                System.out.println(buyer + " doesn't have enough money.");
            }
        } else {
            System.out.println(seller + " can't sell not his phone.");
        }
    }
}
