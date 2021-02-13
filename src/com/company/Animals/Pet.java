package com.company.Animals;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(String specie, Double weight, String name, Double price, Gender gender) throws SQLException {
        super(specie, weight, name, gender);
        this.Price = price;
        //super.save();
    }

    public void stroke() {
        System.out.println("Feels nice.");
    }
}
