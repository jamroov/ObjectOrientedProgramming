package com.company.Devices;

import com.company.Human;
import com.company.Sellable;

public abstract class Device implements Sellable, Comparable<Device> {

    final String vendor;
    final Integer yearOfProduction;
    public Double price;

    public Device(String vendor, Integer yearOfProduction) {
        this.vendor = vendor;
        this.yearOfProduction = yearOfProduction;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Device dev) {
        //When used in ordered sets will sort objects by yearOfProduction
        return this.yearOfProduction.compareTo(dev.yearOfProduction);
    }
    abstract public void turnOn();
    abstract public boolean sell(Human buyer, Human seller);
}
