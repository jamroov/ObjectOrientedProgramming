package com.company.Animals;

import com.company.Human;
import com.company.Sellable;

import java.awt.image.BufferedImage;
import java.io.File;

public class Animal implements Sellable {
    final String specie; //Fields store data

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    private Double weight; //Methods manage data
    public String name;
    protected Double Price;
    File picture; // Path to a picture

    public Animal(String specie, Double weight, Double price) {
        this.specie = specie;
        this.weight = weight;
        this.Price = price;
    }

    public void eat() throws Exception { // void not returning anything
        System.out.println(name + " is eating. Num num num.");
        weight += 1;
    }

    Double feed() { // this returns a double
        System.out.println("Thanks for the food num num num");
        return weight++;
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
}
