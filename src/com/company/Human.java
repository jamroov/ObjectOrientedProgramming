package com.company;

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

    public Human(Double weight) {
        super("Homo-Sapiens", weight);
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
}
