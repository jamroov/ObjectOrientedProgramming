package com.company;

public class Human {
    public String firstName;
    protected String lastName;
    public Animal pet;
    public Phone telephone;
    public Car automobile;

    public Double getAccountValue() {
        return accountValue;
    }

    private Double accountValue = 0.0;

    protected String phoneNumber;
    private Double salary;

    public void Work(Double salary) {
        System.out.println("Working...");
        accountValue += salary;
    }

    public void getCar(Car automobile) {
        this.accountValue -= automobile.getPrice();
        this.automobile = automobile;
    }
}
