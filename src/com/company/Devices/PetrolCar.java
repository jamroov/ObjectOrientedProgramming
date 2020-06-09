package com.company.Devices;

public class PetrolCar extends Car {
    public PetrolCar(String manufacturer, Double price, String licencePlate, Integer yearOfProduction) {
        super(manufacturer, price, licencePlate, yearOfProduction);
        this.setFuelType("Petrol");
    }

    @Override
    public boolean refuel() {
        System.out.println(String.format("Filling tank with %s", this.getFuelType()));
        return true;
    }

    public String toString() {
        return String.format("Car info: %s , %.2f , %s , %s, %s", this.vendor, this.price, this.getFuelType(), this.licencePlate, this.yearOfProduction);
    }
}
