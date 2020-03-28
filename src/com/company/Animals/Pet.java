package com.company.Animals;

public class Pet extends Animal {
    public Pet(String specie, Double weight, Double price) {
        super(specie, weight, price);
    }

    public void stroke() {
        System.out.println("Feels nice.");
    }
}
