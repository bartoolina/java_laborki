package com.company;

public class Main {

    public static void main(String[] args) {
        Human me = new Human("Marcin", "Nowak");

        Animal dog = new Animal("dog");
        dog.name = "Burek";

        Car audi = new Car("Audi", "A3", 2006);

        me.setSalary(1000.0);
        System.out.println(me.getSalary());

        audi.value = 1000.0;
        me.setCar(audi);

        audi.value = 10000.0;
        me.setCar(audi);

        audi.value = 100000.0;
        me.setCar(audi);

    }
}
