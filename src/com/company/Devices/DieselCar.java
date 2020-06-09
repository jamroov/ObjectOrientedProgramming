package com.company.Devices;

public class DieselCar extends Car {
    public DieselCar(String manufacturer, Double price, String licencePlate, Integer yearOfProduction) {
        super(manufacturer, price, licencePlate, yearOfProduction);
        this.setFuelType("Diesel");
    }

    @Override
    public void refuel() {
        System.out.println(String.format("Filling tank with %s", this.getFuelType()));
    }

    public String toString() {
        return String.format("Car info: %s , %.2f , %s , %s, %s", this.vendor, this.price, this.getFuelType(), this.licencePlate, this.yearOfProduction);
    }
}
