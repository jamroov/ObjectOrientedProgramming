package com.company.Animals;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(String specie, Double weight, String name, Double price) throws SQLException {
        super(specie, weight, name);
        this.Price = price;
        super.save();
    }

    public void stroke() {
        System.out.println("Feels nice.");
    }
}
