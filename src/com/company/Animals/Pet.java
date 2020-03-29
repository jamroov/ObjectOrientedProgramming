package com.company.Animals;

public class Pet extends Animal {
    public Pet(String specie, Double weight, String name, Double price) {
        super(specie, weight, name);
        this.Price = price;
    }

    public void stroke() {
        System.out.println("Feels nice.");
    }
}
