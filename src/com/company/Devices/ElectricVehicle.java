package com.company.Devices;

public class ElectricVehicle extends Car {
    public ElectricVehicle(String manufacturer, Double price, String licencePlate, Integer yearOfProduction) {
        super(manufacturer, price, licencePlate, yearOfProduction);
        super.setFuelType("Electricity");
    }

    @Override
    public void refuel() {
        System.out.println(String.format("Filling battery with %s", this.getFuelType()));
    }

    public String toString() {
        return String.format("Car info: %s , %.2f , %s , %s, %s", this.vendor, this.price, this.getFuelType(), this.licencePlate, this.yearOfProduction);
    }
}
