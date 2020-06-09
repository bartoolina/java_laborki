package com.company;

public class Application {
    public String name;
    public String version;
    public Double cost;


    public Application(String name, String version, Double cost) {
        this.name = name;
        this.version = version;
        this.cost = cost;
    }

    public String toString() {
        return "App name: " + name + ", version: " + version + ", cost: " + cost;
    }
}
