package com.company.Devices;

import com.company.Human;

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
    final String licencePlate;

    public Car(String manufacturer, Double price, String fuelType, String licencePlate) {
        super(manufacturer);
        this.licencePlate = licencePlate;
        this.price = price;
        this.fuelType = fuelType;
    }


    @Override
    public void turnOn() {
        System.out.println("Engine is running.");
    }

    @Override
    public boolean sell(Human buyer, Human seller) {
        if (seller.automobile.getPrice() <= buyer.getCash()) {
            buyer.decreaseCash(seller.automobile.getPrice());
            seller.increaseCash(seller.automobile.getPrice());
            buyer.automobile = seller.automobile;
            seller.automobile = null;
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return String.format("%s %s %s %s", this.vendor, this.price, this.licencePlate, this.fuelType);
    }
}
