package com.company;

public class Animal implements salleable {
    public static final Double DEFAULT_DOG_WEIGHT = 10.0;
    public static final Double DEFAULT_MOUSE_WEIGHT = 1.0;
    public static final Double DEFAULT_LION_WEIGHT = 30.0;
    final String species;
    public String name;
    private Double weight;

    public Animal(String species) {
        String spc;
        switch (species) {
            case "dog":
                this.weight = DEFAULT_DOG_WEIGHT;
                spc = species;
                break;
            case "mouse":
                this.weight = DEFAULT_MOUSE_WEIGHT;
                spc = species;
                break;
            case "lion":
                this.weight = DEFAULT_LION_WEIGHT;
                spc = species;
                break;
            default:
                this.weight = 0.0;
                spc = "none";
        }
        this.species = spc;
    }

    void feed() {
        if (weight > 0) {
            weight++;
            System.out.println(name + " is eating. His weight is now " + weight);
        } else {
            System.out.println(name + " can't eat. He is dead.");
        }
    }

    void takeForWalk() {
        if (weight > 0) {
            weight--;
            if (weight <= 0) {
                weight = 0.0;
                System.out.println(name + " was walking and now he is dead");
            } else {

                System.out.println(name + " is walking. His weight is now " + weight);
            }
        } else {
            weight = 0.0;
            System.out.println(name + " can't walk. He is dead.");
        }
    }

    public String toString() {
        return name;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.pet.equals(this)) {
            if (buyer.cash >= price) {
                System.out.println(buyer + "bought a " + this.species + " from " + seller);
                buyer.pet = this;
                buyer.cash -= price;
                seller.pet = null;
                seller.cash += price;
            } else {
                System.out.println(buyer + " doesn't have enough money.");
            }
        } else {
            System.out.println(seller + " can't sell not his animal.");
        }
    }
}
