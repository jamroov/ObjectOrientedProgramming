package com.company.Animals;

public enum foodType {
    MEAT(0.7),
    PLANTS(0.5),
    ANYTHING(0.3);

    public final Double foodToBodyRatio;

    foodType(Double foodToBodyRatio) {
        this.foodToBodyRatio = foodToBodyRatio;
    }
}