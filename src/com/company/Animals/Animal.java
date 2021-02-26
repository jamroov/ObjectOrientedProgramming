package com.company.Animals;

import com.company.Devices.Sellable;
import com.company.database.Connector;

import java.sql.SQLException;
import java.util.Locale;

public abstract class Animal implements Sellable, Feedable {
    private String specie; //Fields store data
    private Double weight; //Methods manage data
    public String name;
    protected Double Price;
    private Boolean Alive = true;
    final Gender gender;
    final foodType foodType;

    final Double DEFAULT_FEED_PRICE = 10.0;

    public Boolean getAlive() {
        return Alive;
    }

    public Animal(String specie, Double weight, String name, Gender gender, foodType foodType) throws SQLException {
        this.specie = specie;
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.foodType = foodType;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void eat() throws Exception { // void not returning anything
        System.out.println(name + " is eating. Num num num.");
        weight += 1;
    }

    public Double feed() {
        return feed(1.0, DEFAULT_FEED_PRICE, com.company.Animals.foodType.ANYTHING);
    }

    public Double feed(Double amount, Double price, foodType foodType) {
        Double ratio = 0.0;
        if ( this.weight <= 0 || !this.Alive ) {
            System.out.println("Animal is dead");
            return this.weight;
        }
        switch (this.foodType) {
            case MEAT:
            case PLANTS: ;
            case ANYTHING:
                ratio = foodType.foodToBodyRatio;
                break;
            default:
                System.out.println("I can't eat that.");
                return this.weight;
        }
        this.weight += ratio * amount;
        System.out.println("Thanks for the food num num num");
        System.out.println(String.format("The food costs: %.2f", price));
        return this.weight;
    }

    public Double getWeight() {
        return weight;
    }

    public String getSpecie() {
        return this.specie;
    }

    public Double walk() {
        weight -= 1;
        if (weight < 0) {
            System.out.println("Too many walks, animal is dead");
        }
        else {
            System.out.printf("Weight is now: %s%n", weight);
            return 0.0;
        }
        return weight;
    }

    @Override
    public boolean sell(Human buyer, Human seller) throws Exception {
        System.out.println("Am sold... \n");
        return true;
    }

    public boolean kill() {
        this.Alive = false;
        return false;
    }

    public String toString() {
        return String.format("Hello my name is %s, I am a %s and weigh %.2f and am worth %.2f dollars", this.name, this.specie, this.weight, this.Price);
    }

    public void save() throws SQLException {
        String sql = String.format(Locale.US,"insert into animals values('%s', '%.2f', '%s', '%.2f', '%b')", this.specie, this.weight, this.name, this.Price, this.Alive);
        System.out.println(sql);
        Connector.executeSQL(sql);
    }
}
