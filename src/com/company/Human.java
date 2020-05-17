package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;

public class Human {
    String firstName;
    String lastName;
    public static final Double DEFAULT_SALARY = 0.0;
    private Double salary = DEFAULT_SALARY;
    private ArrayList<Pair<LocalDate, Double>> salaryHistory = new ArrayList<>();
    public Animal pet;
    private Car car;
    public Phone phone;
    public Double cash;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Double getSalary() {
        for (var record : salaryHistory) {
            System.out.println(record.getKey() + " " + record.getValue());
        }
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary > 0.0) {
            LocalDate now = LocalDate.now();
            salaryHistory.add(new Pair<>(now, salary));

            System.out.println("New value of salary has been added to salary history.");
            System.out.println("Please pick up the annex to the contract form Mrs Hania.");
            System.out.println("ZUS and US has been informed.");

            this.salary = salary;
        } else {
            System.out.println("Cannot add a negative value");
        }
    }

    public Car getCar() {
        return car;
    }

    public boolean setCar(Car car, Double price) {
        boolean bought = false;
        if (price == 0.0) {
            this.car = car;
            return true;
        }

        if (price <= cash) {
            System.out.println(this.firstName + " " + this.lastName + " bought " + car.model + " for cash.");
            this.car = car;
            this.cash -= price;
            bought = true;
        } else if (price <= salary * 12) {
            System.out.println(this.firstName + " " + this.lastName + " bought " + car.model + " on credit.");
            this.car = car;
            bought = true;
        } else {
            System.out.println(this.firstName + " " + this.lastName + " doesn't have enough money.");
        }

        return bought;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
