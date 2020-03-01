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


}
