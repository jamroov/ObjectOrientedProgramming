package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Feedable;
import com.company.Devices.Car;
import com.company.Devices.Phone;
import com.company.buildings.Garage;

import java.sql.SQLException;
import java.util.Date;

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

    public void setAutomobile(Car automobile) {
        this.automobile = automobile;
    }

    public Human(Double weight, String name, String lastName) throws SQLException {
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

    public void setSalary(Double salary) {
        if (salary <= 0) {
            System.out.println("Unable to set salary to none or zero");
            return;
        }
        System.out.println("Salary data annex sending to accounting...");
        System.out.println("Please contact Joanna Nowak for details about salary annex...");
        System.out.println("Public Health Insurance and Tax Office know of salary change and there is no use to hide your real income.");
        this.salary = salary;
    }

    public void increaseSalary(Double byThisMuch) {
        if (byThisMuch < 0.00) {
            System.out.println("This is not a raise");
            return;
        }
        System.out.println("You got a raise today on: " + new Date());
        System.out.println("Old salary: " + this.salary);
        System.out.println("New salary: " + (this.salary + byThisMuch ));
        this.setSalary(this.salary + byThisMuch);
    }

    public Car getAutomobile() {
        return automobile;
    }

    //Setter:
    public void buyCar(Car automobile) {
        if (this.salary > automobile.getPrice()) {
            if (this.accountValue >= automobile.getPrice()) {
                this.accountValue -= automobile.getPrice();
            }
            else {
                System.out.println("Inssufficient funds but you will pay next month.");
            }
            System.out.println("Congrats, you now own a car.");
            this.automobile = automobile;
            automobile.owners.add(this.getFullName());
            automobile.setMyGarage(this.garage);
        }
        else if (this.salary > automobile.getPrice()/60) {
            System.out.println("You had to take a loan to get your car.");
            this.automobile = automobile;
            automobile.owners.add(this.getFullName());
            automobile.setMyGarage(this.garage);
        }
        else {
            System.out.println("You can't buy a car, you need to earn more.");
        }
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
