package com.company.Devices;

import com.company.Animals.Human;
import com.company.Annotations.Mapped;
import jdk.jfr.MemoryAddress;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Phone extends Device {
    @Mapped
    final Double screenSize;
    static final String serverAddress = "http://server.com";
    static final String defaultProtocol = "IMAP";
    static final Double defaultVersion = 1.0;
    static final Double defaultAppPrice = 0.0;
    @Mapped
    public ArrayList<Application> installedApps = new ArrayList<>();
    @Mapped
    private ArrayList<String> installedAppsNames = new ArrayList<>();
    @Mapped
    final OperatingSystem operatingSystem;

    public Phone(String vendor, Double screenSize, Integer yearOfProduction, Double price, OperatingSystem operatingSystem) {
        super(vendor, yearOfProduction, price);
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
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

    public boolean installAnApp(String name) {
        installAnApp(name, 0.0);
        return true;
    }

    public boolean installAnApp(String[] apps) {
        for (String app : apps ) {
            installAnApp(app);
        }
        return true;
    }

    public boolean installAnApp(String name, Double version) {

        if (version > 0.0) {
            System.out.println(String.format("The app %s %.2f is installed", name, version));
        }
        else {
            System.out.println(String.format("The app %s is installed", name));
        }
        return true;
    }

    public boolean installAnApp(Application app) {
        if (!isAppInstalled(app)) {
            this.installedApps.add(app);
            this.installedAppsNames.add(app.name);
            System.out.println(app.name + " installed.");
            return true;
        }
        System.out.println(app.name + " already installed.");
        return false;
    }

    public boolean installAnApp(String name, Double version, Double price) {
        Application thisAPP = new Application(name, version, price);
        if (!isAppInstalled(thisAPP)) {
            this.installedApps.add(thisAPP);
            this.installedAppsNames.add(name);
            System.out.println(name + " installed.");
            return true;
        }
        System.out.println(name + " already installed.");
        return false;
    }

    boolean isAppInstalled(Application app) {
        return isAppInstalled(app.name);
    }

    boolean isAppInstalled(String name) {
        return this.installedAppsNames.contains(name);
    }

    public Set<Application> getAllApps() {
        return new HashSet<>(this.installedApps);
    }

    public void printAllAppsOrdered(String key) {
        if (key.equals("name")) {
            TreeSet<String> namesSet = new TreeSet<>(this.installedAppsNames);
            for (String name : namesSet) {
                System.out.println(name);
            }
        }
        else if (key.equals("price")) {
            TreeSet<Application> appsByPrice = new TreeSet<>(this.installedApps);
            for (Application app : appsByPrice) {
                System.out.println(app.toString());
            }
        }
    }

    public String toString() {
        String msg = "";
        msg = "This is a phone by: %s screen size: %f, production: %d, price: %f, os: %s";
        switch (this.operatingSystem) {
            case iOS:
                msg += ", it costs an arm and a leg.";
                break;
            case ANDROID:
                msg += ", it wishes it was an iPhone";
                break;
            case LINUX:
                msg += ", look, a penguin!";
                break;
            case WINDOWS:
                msg += ", how am I still running?";
                break;
            default:
                msg += ", it runs ASM";
                break;
        }
        return String.format(msg,
                this.vendor, this.screenSize, this.yearOfProduction,
                this.price, this.operatingSystem.name());
    }
}
