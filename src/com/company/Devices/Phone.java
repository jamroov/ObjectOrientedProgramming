package com.company.Devices;

public class Phone extends Device {
    final Double screenSize;

    public Phone(String vendor, Double screenSize) {
        super(vendor);
        this.screenSize = screenSize;
    }

    //Abstract class: you know what you need - you can only extend one class
    //Interface: you don't know what you need but you know that you will need a lot of it. like all things here can be sold,
    //how to sell depends on more granualr implementation in each class. - you can imlpement any number of interfaces

    @Override
    public void turnOn() {
        System.out.println("Phone is turned on now.\n");
    }

    @Override
    public void sell() {
        System.out.println("Thanks for buying my old phone.");
    }
}
