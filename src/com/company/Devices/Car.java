package com.company.Devices;

import com.company.Animals.Human;
import com.company.buildings.Garage;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class Car extends Device {
    private String fuelType = "Unknown";
    final String licencePlate;
    public ArrayList<String> owners = new ArrayList<>();
    private Garage myGarage;
    public final String model;

    public Car(String manufacturer, Double price, String licencePlate, Integer yearOfProduction, String model) {
        super(manufacturer, yearOfProduction, price);
        this.licencePlate = licencePlate;
        this.model = model;
    }
    public Double getPrice() {
        return price;
    }
    public String getManufacturer() {
        return super.vendor;
    }
    public String getFuelType() {
        return fuelType;
    }
    public String getLicencePlate() {
        return licencePlate;
    }

    public void setMyGarage(Garage myGarage) {
        this.myGarage = myGarage;
    }

    public Garage getMyGarage() {
        return this.myGarage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;
        return this.getLicencePlate().equals(car.getLicencePlate());
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void turnOn() {
        System.out.println("Engine is running.");
    }

    @Override
    public boolean sell(Human buyer, Human seller) {
        if (seller.automobile != this) {
            System.out.println("You can't sell something you don't own");
            return false;
        }
        if (seller.automobile.getPrice() <= buyer.getCash()) {
            buyer.decreaseCash(seller.automobile.getPrice());
            seller.increaseCash(seller.automobile.getPrice());
            buyer.automobile = seller.automobile;
            owners.add(buyer.getFullName());
            seller.automobile = null;
            seller.garage.removeCar(this);
            buyer.garage.storeCar(this);
            this.setMyGarage(buyer.garage);
            return true;
        }
        else {
            System.out.println("This car is too expensive for you.");
            return false;
        }
    }

    //Check if am owner
    public Boolean wasOwner(String name) {
        return owners.contains(name);
    }

    public Boolean isCurrOwner(String name) {
        //Check if name is last in the list of owners aka current owner
        return owners.get(owners.size() - 1).equals(name);
    }

    public Integer getNumOwners() {
        return owners.size();
    }

    public Boolean haveSold(String owner, String prevOwner) {
        //We check if owner is one position over previous owner
        return owners.lastIndexOf(owner) - owners.lastIndexOf(prevOwner) == 1;
    }

    public void printOwnerHistory() {
        System.out.println("My owners so far were:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(String.format("%d: %s", i+1, owners.get(i)));
        }
    }

    public String toString() {
        return String.format("%s %s %s %s %s %s", this.vendor, this.model, this.price, this.licencePlate, this.fuelType, this.yearOfProduction);
    }

    public abstract void refuel();
}
