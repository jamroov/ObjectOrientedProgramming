package com.company.Devices;

import com.company.Human;
import com.company.Sellable;

public abstract class Device implements Sellable {

    final String vendor;
    public Double price;

    public Device(String vendor) {
        this.vendor = vendor;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public Double getPrice() {
        return this.price;
    }

    abstract public void turnOn();
    abstract public boolean sell(Human buyer, Human seller);
}
