package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Feedable;
import com.company.Devices.Car;
import com.company.Devices.Phone;
import com.company.buildings.Garage;

public class Human extends Animal implements Feedable {  // Inheritance
    public String firstName;
    public String lastName;
    public Animal pet;
    public Phone telephone;
    public Car automobile;
    public Garage garage;
    private Double accountValue = 0.0;
    protected String phoneNumber;
    private Double salary;
    protected Double cash = 1500.00;


    public Human(Double weight, String name, String lastName) {
        super("Homo-Sapiens", weight, name);
        this.firstName = name;
        this.lastName = lastName;
    }

    public Double getCash() {
        return cash;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Garage getGarage() {
        return this.garage;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public void increaseCash(Double cash) {
        this.cash += cash;
    }

    public void decreaseCash(Double cash) {
        this.cash -= cash;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public void Work(Double salary) {
        System.out.println("Working...");
        this.accountValue += salary;
    }

    public Double getAccountValue() {
        return accountValue;
    }

    public void getCar(Car automobile) {
        this.accountValue -= automobile.getPrice();
        this.automobile = automobile;
        automobile.owners.add(this.getFullName());
        automobile.setMyGarage(this.garage);
    }

    public Double getSalary(String pass) {
        if (isPassValid(pass)) {
            return salary;
        } else {
            System.out.println("Authentication failure.");
            return 0.0;
        }
    }

    public void sell() throws Exception {
        throw new Exception("Don't sell humans goddamit.");
    }

    public void eat() throws Exception {
        throw new Exception("Don't eat humans...");
    }

    private boolean isPassValid(String pass) {
        return false;
    }

    public Double feed(Integer amount, Double price) {
        if (!this.getAlive()) {
            System.out.println("Am dead");
            return 0.0;
        }
        if (price * amount > this.cash) {
            System.out.println("CAnnot afford that");
            return 0.0;
        }
        super.feed(amount, amount * price);
        this.decreaseCash(price*amount);
        return this.getWeight();
    }

    public String toString() {
        return String.format("Hello my name is %s, I am a %s and weigh %.2f",this.name,this.getSpecie(),this.getWeight());
    }

    public void startFeeding(Feedable feedable, Integer amount, Double price) {
        System.out.println("Now " + this.firstName + " feed something");
        feedable.feed(amount, price);
    }
}
