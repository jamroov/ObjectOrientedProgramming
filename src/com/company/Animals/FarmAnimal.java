package com.company.Animals;

import com.company.Edible;

import java.sql.SQLException;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal(String name, String specie, Double weight, Double price) throws SQLException {
        super( specie, weight, name);
        super.Price = price;
        super.save();
    }

    @Override
    public void eatIt() throws Exception {
        System.out.println("Am eaten.");
        this.setWeight(0.0);
        this.kill();
    }
}
