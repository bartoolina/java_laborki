package com.company;

public class Main {

    public static void main(String[] args) {
        Human me = new Human();

        Animal dog = new Animal("dog");
        dog.name = "Burek";

        Car audi = new Car("Audi", "A3", 2006);
        me.car = audi;

    }
}
