package com.company.Animals;

import com.company.Edible;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal(String name, String specie, Double weight, Double price) {
        super( specie, weight, name);
        super.Price = price;
    }

    @Override
    public void eatIt() throws Exception {
        System.out.println("Am eaten.");
        this.setWeight(0.0);
        this.kill();
    }
}
