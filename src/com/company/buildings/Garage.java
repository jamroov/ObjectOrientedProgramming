package com.company.buildings;

import com.company.Devices.Car;
import com.company.Human;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.TreeSet;

public class Garage {
    final public Integer capacity;
    final public Human owner;
    public Set<Car> cars = new TreeSet<Car>();

    public Garage(Integer capacity, @NotNull Human owner) {
        this.capacity = capacity;
        this.owner = owner;
        owner.garage = this;
    }

    public Boolean carIsStored(Car CarToStore) {
        for (Car car : cars) {
            if (car.equals(CarToStore))
                return true;
        }
        return false;
    }

    public void storeCar(Car carToStore) {
        if (!carIsStored(carToStore))
            cars.add(carToStore);
        else
            System.out.println("This car is already in the garage.");
    }

    public void listCars() {
        System.out.println("Cars currently in the garage:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public void removeCar(Car carToRemove) {
        cars.remove(carToRemove);
    }

    public void sortCars() {
        //Cars are automatically sorted by yearOfProduction when added
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
