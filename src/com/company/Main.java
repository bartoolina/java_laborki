package com.company;

import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {
        Human me = new Human("Marcin", "Nowak");

        Pet dog = new Pet("dog");
        dog.name = "Burek";

        Car audi = new Car("Audi", "A3", 2006);
        Phone samsung = new Phone("Samsung", "S7", 2019);

        me.setSalary(1000.0);
        System.out.println(me.getSalary());

        me.cash = 1000.0;
        audi.value = 1000.0;
        me.setCar(audi, 1000.0);

        audi.value = 10000.0;
        me.setCar(audi, 10000.0);

        audi.value = 100000.0;
        me.setCar(audi, 100000.0);
        System.out.println(me);
        System.out.println(dog);
        System.out.println(samsung);
        System.out.println(audi);

        audi.turnOn();
        samsung.turnOn();

        Human janusz = new Human("Janusz", "Kowalski");
        janusz.cash = 2000.0;
        audi.sell(me, janusz, 1000.0);
        me.cash = 1000.0;
        audi.sell(janusz, me, 1500.0);
        audi.sell(me, janusz, 20000.0);

        samsung.sell(me, janusz, 100.0);

        FarmAnimal cow = new FarmAnimal("cow");
        cow.name = "Mućka";
        cow.feed(10.0);
        cow.beEaten();

        dog.feed(5.0);

    }
}
