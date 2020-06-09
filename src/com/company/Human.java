package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Phone;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Human {
    String firstName;
    String lastName;
    public static final Double DEFAULT_SALARY = 0.0;
    public static final int DEFAULT_PARKING_SPACES = 4;
    private Double salary = DEFAULT_SALARY;
    private final ArrayList<Pair<LocalDate, Double>> salaryHistory = new ArrayList<>();
    public Animal pet;
    private final int numberOfSpaces;
    private final Car[] garage;
    public Phone phone;
    public Double cash;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfSpaces = DEFAULT_PARKING_SPACES;
        this.garage = new Car[numberOfSpaces];
    }

    public Human(String firstName, String lastName, int numberOfParkingSpaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfSpaces = numberOfParkingSpaces;
        this.garage = new Car[numberOfParkingSpaces];
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

    public Car getCar(int carNumber) {
        if (carNumber < 0 || carNumber >= numberOfSpaces) return null;
        return garage[carNumber];
    }

    public int getCarNumber(Car car) {
        if (car == null) return -1;
        for (int i = 0; i < numberOfSpaces; i++) {
            if (car == garage[i]) return i;
        }
        return -1;
    }

    public Double getValueOfCars() {
        Double valueAll = 0.0;
        for (Car car : garage) {
            if (car != null) valueAll += car.value;
        }
        return valueAll;
    }

    public void sortGarage() {
        Arrays.sort(garage);
    }

    public int getFirstSpace() {
        for (int i = 0; i < numberOfSpaces; i++) {
            if (garage[i] == null) return i;
        }
        return -1;
    }

    public boolean setCar(Car car, Double price, int spaceNumber) {
        boolean bought = false;
        if (spaceNumber < 0 || spaceNumber >= numberOfSpaces) return false;
        if (price == 0.0) {
            this.garage[spaceNumber] = car;
            return true;
        }

        if (price <= cash) {
            System.out.println(this.firstName + " " + this.lastName + " bought " + car.model + " for cash.");
            this.garage[spaceNumber] = car;
            this.cash -= price;
            bought = true;
        } else if (price <= salary * 12) {
            System.out.println(this.firstName + " " + this.lastName + " bought " + car.model + " on credit.");
            this.garage[spaceNumber] = car;
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
