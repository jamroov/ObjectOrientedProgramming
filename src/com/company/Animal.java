package com.company;

import java.awt.image.BufferedImage;
import java.io.File;

public class Animal {
    final String specie; //Fields store data
    private Double weight; //Methods manage data
    public String name;
    File picture; // Path to a picture

    public Animal(String specie, Double weight) {
        this.specie = specie;
        this.weight = weight;
    }

    void eat() { // void not returning anything
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

    Double walk() {
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
}
