package com.company.Animals;

import com.company.Human;
import com.company.Sellable;

import java.awt.image.BufferedImage;
import java.io.File;

public class Animal implements Sellable {
    final String specie; //Fields store data
    private Double weight; //Methods manage data
    public String name;
    protected Double Price;

    public Boolean getAlive() {
        return Alive;
    }

    private Boolean Alive = true;

    public Animal(String specie, Double weight, String name) {
        this.name = name;
        this.specie = specie;
        this.weight = weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void eat() throws Exception { // void not returning anything
        System.out.println(name + " is eating. Num num num.");
        weight += 1;
    }

    public Double feed() {
        return feed(1);
    }

    public Double feed(int amount) {
        if ( this.weight <= 0.0 || !this.Alive ) {
            System.out.println("Animal is dead");
            return 0.0;
        }
        System.out.println("Thanks for the food num num num");
        this.weight += amount;
        return this.weight;
    }

    public Double getWeight() {
        return weight;
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
        return String.format("Hello my name is, I am a %s and weigh %.2f and am worth %.2f dollars", this.name, this.specie, this.weight, this.Price);
    }
}
