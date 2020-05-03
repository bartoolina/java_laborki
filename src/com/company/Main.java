package com.company;

public class Main {

    public static void main(String[] args) {
        Human me = new Human("Marcin", "Nowak");

        Animal dog = new Animal("dog");
        dog.name = "Burek";

        Car audi = new Car("Audi", "A3", 2006);
        me.car = audi;

        System.out.println(me.getSalary());
        me.setSalary(2000.0);
        me.setSalary(2500.0);
        me.setSalary(-1.0);
        System.out.println(me.getSalary());
    }
}
