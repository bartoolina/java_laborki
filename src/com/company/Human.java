package com.company;

import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;

public class Human {
    String firstName;
    String lastName;
    public static final Double DEFAULT_SALARY = 0.0;
    private Double salary = DEFAULT_SALARY;
    Animal pet;
    Car car;
    private ArrayList<Pair<LocalDate, Double>> salaryHistory = new ArrayList<>();

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
            salaryHistory.add(new Pair<LocalDate, Double>(now, salary));

            System.out.println("New value of salary has been added to salary history.");
            System.out.println("Please pick up the annex to the contract form Mrs Hania.");
            System.out.println("ZUS and US has been informed.");

            this.salary = salary;
        } else {
            System.out.println("Cannot add a negative value");
        }
    }

}
