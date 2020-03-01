package com.company.Devices;

public class Car extends Device {

    public Double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return super.vendor;
    }

    public String getFuelType() {
        return fuelType;
    }

    final String fuelType;

    public Car(String manufacturer, Double price, String fuelType) {
        super(manufacturer);
        this.price = price;
        this.fuelType = fuelType;
    }


    @Override
    public void turnOn() {
        System.out.println("Engine is running.");
    }

    @Override
    public void sell() {
        System.out.println("Gib me money for this");
    }
}
