package com.company.Devices;

import com.company.Animals.Human;

public interface Sellable {
    public boolean sell(Human buyer, Human seller) throws Exception;
}
