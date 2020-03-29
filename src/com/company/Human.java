package com.company;

import com.company.Animals.Animal;
import com.company.Devices.Car;
import com.company.Devices.Phone;

public class Human extends Animal {  // Inheritance
    public String firstName;
    protected String lastName;
    public Animal pet;
    public Phone telephone;
    public Car automobile;
    private Double accountValue = 0.0;
    protected String phoneNumber;
    private Double salary;
    protected Double cash = 1500.00;

    public Double getCash() {
        return cash;
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

    public Human(Double weight, String name) {
        super("Homo-Sapiens", weight, name);
        this.firstName = name;
    }

    public void Work(Double salary) {
        System.out.println("Working...");
        accountValue += salary;
    }

    public Double getAccountValue() {
        return accountValue;
    }
    public void getCar(Car automobile) {
        this.accountValue -= automobile.getPrice();
        this.automobile = automobile;
    }

    public Double getSalary(String pass) {
        if (isPassValid(pass)) {
            return salary;
        }
        else {
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

    public Double feed(Double amount, Double price) {
        if (!this.getAlive()) {
            System.out.println("Am dead");
            return 0.0;
        }
        if (price*amount > this.cash) {
            System.out.println("CAnnot afford that");
            return 0.0;
        }
        this.setWeight(this.getWeight()+amount);
        return this.getWeight();
    }
}
