package com.company.Devices;

import com.company.Human;

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
    public boolean sell(Human buyer, Human seller) {
        if (seller.telephone != this) {
            System.out.println("You can't sell something you don't own");
            return false;
        }
        if (seller.telephone.getPrice() <= buyer.getCash()) {
            buyer.decreaseCash(seller.telephone.getPrice());
            seller.increaseCash(seller.telephone.getPrice());
            buyer.telephone = seller.telephone;
            seller.telephone = null;
            System.out.println("Success");
            return true;
        }
        else {
            System.out.println("Not enough cash");
            return false;
        }
    }
}
