package com.company.devices;

import com.company.Human;
import com.company.salleable;

import java.util.ArrayList;
import java.util.List;

public abstract class Car extends Device implements salleable, Comparable<Car> {
    //    public Double value;
    public List<Human> owners;

    public Car(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
        owners = new ArrayList<Human>();
    }

    public abstract void refuel();

    public int compareTo(Car other) {
        if (this == null && other == null) {
            return 0;
        } else if (this == null) {
            return -1;
        } else if (other == null) {
            return 1;
        }

        return (this.yearOfProduction - other.yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Engine is on.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        int sellerCarNumber = seller.getCarNumber(this);
        if (sellerCarNumber >= 0 && seller.equals(this.owners.get(this.owners.size() - 1))) {
            int buyerSpaceNumber = buyer.getFirstSpace();
            if (buyerSpaceNumber >= 0) {
                if (buyer.setCar(this, price, buyerSpaceNumber)) {
                    System.out.println(buyer + " bought a " + this + " from " + seller);

                    seller.setCar(null, 0.0, sellerCarNumber);
                    seller.cash += price;
                } else {
                    System.out.println("The transaction has not taken place");
                    throw new Exception("The transaction has not taken place");
                }

            } else {
                System.out.println(buyer + " has not free space in his garage.");
                throw new Exception(buyer + " has not free space in his garage.");
            }
        } else {
            System.out.println(seller + " can't sell not his car.");
            throw new Exception(seller + " can't sell not his car.");
        }
    }

    public boolean wasOwner(Human human) {
        return owners.contains(human);
    }

    public int countTransaction() {
        return owners.size();
    }
}
