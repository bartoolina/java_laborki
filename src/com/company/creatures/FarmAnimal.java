package com.company.creatures;

public class FarmAnimal extends Animal implements Edbile {
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        this.weight = 0.0;
        System.out.println("We have delicious food from " + name);
    }


}
