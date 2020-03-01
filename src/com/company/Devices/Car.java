package com.company.Devices;

public class Car {
    final String manufacturer;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getFuelType() {
        return fuelType;
    }

    final String fuelType;

    public Car(String manufacturer, Double price, String fuelType) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.fuelType = fuelType;
    }


}
