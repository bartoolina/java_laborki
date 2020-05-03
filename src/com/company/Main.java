package com.company;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Animal("dog");
        dog.name = "Burek";

        dog.feed();
        // pies ma wage 11
        for (int i = 0; i < 12; i++) {
            dog.takeForWalk();
        }
        dog.feed();


    }
}
