package com.company.Devices;

public class Application implements Comparable<Application>{
    public String name;
    public Double version;
    public Double price;

    public Application(String name, Double version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    @Override
    public int compareTo(Application app) {
        //When used in ordered sets will sort objects by yearOfProduction
        return this.price.compareTo(app.price);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, price: %f, version: %f", this.name, this.price, this.version);
    }
}
