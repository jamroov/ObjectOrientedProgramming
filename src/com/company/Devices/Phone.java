package com.company.Devices;

public class Phone extends Device {
    final Double screenSize;

    public Phone(String vendor, Double screenSize) {
        super(vendor);
        this.screenSize = screenSize;
    }


    @Override
    public void turnOn() {
        System.out.println("Phone is turned on now.\n");
    }

    @Override
    public void sell() {
        System.out.println("Thanks for buying my old phone.");
    }
}
