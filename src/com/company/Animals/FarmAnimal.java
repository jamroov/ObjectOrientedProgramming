package com.company.Animals;

import com.company.Edible;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal(String specie, Double weight, Double price) {
        super(specie, weight, price);
    }

    @Override
    public void Eat_it() throws Exception {
        System.out.println("Am eaten.");
        this.setWeight(0.0);
    }
}
