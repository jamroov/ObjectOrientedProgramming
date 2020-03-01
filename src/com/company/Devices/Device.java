package com.company.Devices;

public class Device {

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
}
