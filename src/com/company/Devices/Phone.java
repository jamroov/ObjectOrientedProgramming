package com.company.Devices;

public class Phone extends Device{
    final Double screenSize;

    public Phone(String vendor, Double screenSize) {
        super(vendor);
        this.screenSize = screenSize;
    }
}
