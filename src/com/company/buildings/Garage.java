package com.company.buildings;

import com.company.Devices.Car;

import java.util.*;

public class Garage {
    final public Integer capacity;
    public Set<Car> cars = new TreeSet<Car>();

    public Garage(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean carIsStored(Car CarToStore) {
        for (Car car : cars) {
            if (car.equals(CarToStore))
                return true;
        }
        return false;
    }

    public void storeCar (Car carToStore) {
        if (!carIsStored(carToStore))
            cars.add(carToStore);
        else
            System.out.println("This car is already in the garage.");
    }

    public void listCars () {
        System.out.println("Cars currently in the garage:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public void sortCars() {
        System.out.println("Sorting...");
    }

    public Double sumValueOfCars() {
        Double value = 0.00;
        for (Car car : cars) {
            value += car.getPrice();
        }
        return value;
    }
}
