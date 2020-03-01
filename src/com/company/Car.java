package com.company;

public class Car {
    final String manufacturer;
    private Double price;

    public Double getPrice() {
        return price;
    }

    final String fuelType;

    public Car(String manufacturer, Double price, String fuelType) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.fuelType = fuelType;
    }
}
