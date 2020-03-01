package com.company.Devices;

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

    abstract public void turnOn(); // this is only a template so we know it should return nothing and have something to do with
                            // turning the device on
}
