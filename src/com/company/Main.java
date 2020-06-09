package com.company;

import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Disel;
import com.company.devices.Phone;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Human me = new Human("Marcin", "Nowak");

        Pet dog = new Pet("dog");
        dog.name = "Burek";

        Car audi = new Disel("Audi", "A3", 2006);
        Phone samsung = new Phone("Samsung", "S7", 2019);

        me.setSalary(1000.0);
        System.out.println(me.getSalary());

        me.cash = 1000.0;
        audi.value = 1000.0;
        me.setCar(audi, 1000.0, 0);
        System.out.println("Was " + me + " the owner of the car? " + audi.wasOwner(me));
        audi.turnOn();
        samsung.turnOn();

        Human janusz = new Human("Janusz", "Kowalski");
        System.out.println("Was " + janusz + " the owner of the car? " + audi.wasOwner(janusz));
        janusz.cash = 2000.0;
        audi.sell(me, janusz, 1000.0);
//        me.cash = 1000.0;
//        audi.sell(janusz, me, 1500.0);
//        audi.sell(me, janusz, 20000.0);
//        System.out.println("Was " + janusz + " the owner of the car? " + audi.wasOwner(janusz));
//
//        Car skoda = new Electric("Skoda", "Rapid", 2020);
//        skoda.sell(me, janusz, 100.0);
//        skoda.value = 20000.0;
//        me.setCar(skoda, 100.0, 1);
//        System.out.println(me + " has cars with a total value " + me.getValueOfCars());
//        Car ford = new LPG("Ford", "Taurus", 1969);
//        ford.value = 200.0;
//        me.setCar(ford, 0.0, 2);
//        System.out.println();


        samsung.sell(me, janusz, 100.0);

        FarmAnimal cow = new FarmAnimal("cow");
        cow.name = "Mućka";
        cow.feed(10.0);
        cow.beEaten();

        dog.feed(5.0);

        samsung.installAnnApp("app1");
        samsung.installAnnApp("app2", "EN");
        URL addr = new URL("https", "www.pirat.com", "/app3?FR");
        samsung.installAnnApp(addr);

        Application tinder = new Application("Tinder", "latest", 10.0);
        Application kinder = new Application("Kinder", "latest", 20.0);
        Application binder = new Application("Binder", "latest", 5.0);
        Application linder = new Application("Linder", "latest", 0.0);
        samsung.installNewApp(tinder, me);
        samsung.installNewApp(kinder, me);
        samsung.installNewApp(binder, me);
        samsung.installNewApp(linder, me);

        System.out.println("Is Tinder installed? " + samsung.isAppInstall(tinder));
        Application hinder = new Application("Hinder", "latest", 0.0);
        System.out.println("Is Hinder installed? " + samsung.isAppInstall(hinder));

        System.out.println("Is Kinder installed? " + samsung.isAppInstall("Kinder"));
        System.out.println(samsung.getAllFreeApp());
        samsung.installNewApp(hinder, me);
        System.out.println(samsung.getAllFreeApp());

        System.out.println("All apps cost: " + samsung.getValueAllApp());

        System.out.println(samsung.getAppsSortedByName());
        System.out.println(samsung.getAppsSortedByValue());
    }
}
