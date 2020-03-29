package com.company;

import com.company.Animals.FarmAnimal;
import com.company.Animals.Pet;
import com.company.Devices.Car;
import com.company.Devices.Device;
import com.company.Devices.Phone;

public class Main {

    public static void main(String[] args) throws Exception {
        Human stefan = new Human(80.0, "Stefan");
        stefan.setCash(10.00);
        System.out.println(stefan.feed(4, 1.0));
        System.out.println(stefan.getCash());
        System.out.println(stefan.getWeight());
        System.out.println(stefan.toString());

        FarmAnimal Helga = new FarmAnimal("Helga", "Pigus-maximus", 125.00, 849.00);
        Helga.feed();
    }
}
