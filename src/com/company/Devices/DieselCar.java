package com.company.Devices;

public class DieselCar extends Car {
    public DieselCar(String manufacturer, Double price, String licencePlate) {
        super(manufacturer, price, licencePlate);
        this.setFuelType("Diesel");
    }

    @Override
    public boolean refuel() {
        System.out.println(String.format("Filling tank with %s", this.getFuelType()));
        return true;
    }

    public String toString() {
        return String.format("Car info:\n%s,\n%.2f,\n%s,\n%s", this.vendor, this.price, this.getFuelType(), this.licencePlate);
    }
}
