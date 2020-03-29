package com.company.Devices;

public class ElectricVehicle extends Car {
    public ElectricVehicle(String manufacturer, Double price, String licencePlate) {
        super(manufacturer, price, licencePlate);
        super.setFuelType("Electricity");
    }

    @Override
    public boolean refuel() {
        System.out.println(String.format("Filling battery with %s", this.getFuelType()));
        return true;
    }

    public String toString() {
        return String.format("Car info: %s\n, %.2f\n, %s\n, %s", this.vendor, this.price, this.getFuelType(), this.licencePlate);
    }
}
