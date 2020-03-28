package com.company;

import com.company.Animals.Animal;
import com.company.Animals.FarmAnimal;
import com.company.Animals.Pet;
import com.company.Devices.Car;
import com.company.Devices.Device;
import com.company.Devices.Phone;

public class Main {

    public static void main(String[] args) throws Exception {

        Pet burek = new Pet("Dog", 10.5, 150.00);
        Pet felek = new Pet("Dog", 20.1, 00.00);
        FarmAnimal krasula = new FarmAnimal("Cow", 300.5, 1250.00);
        FarmAnimal helga = new FarmAnimal("Pig", 289.00, 940.00);

        krasula.Eat_it();
        helga.Eat_it();

        burek.name = "Burek";
        Car opel = new Car("Opel", 72000.00, "Diesel", "GD1234J");
        Phone HujwejMejt10 = new Phone("Hujwej", 5.6);
        HujwejMejt10.price = 1099.0;

        Human jan_kowalski = new Human(80.0);
        jan_kowalski.firstName = "Jan";
        jan_kowalski.lastName = "Kowalski";
        jan_kowalski.pet = burek;
        jan_kowalski.telephone = HujwejMejt10;
        jan_kowalski.pet.name = "Burek";

        Human grazyna_kowalska = new Human(65.0);

        System.out.println(jan_kowalski.pet.getWeight());
        System.out.println("Something is changed now");
        while (true) {
            if (jan_kowalski.pet.walk().equals(0.0)) {
                System.out.println("Dog is ok");
            }
            else {
                System.out.println("Dog is dead");
                burek = null;
                System.out.println(jan_kowalski.pet.getWeight());
                break;
            }
        }
        int count = 1;
        double salary = 800.07;
        while (jan_kowalski.getAccountValue() < opel.getPrice()) {
            jan_kowalski.Work(salary);
            if (count%6 == 0) {
                salary += 150;
           }
           count++;
        }
        System.out.printf("I have %.2f of money  before buying an opel\n", jan_kowalski.getAccountValue());
        System.out.println("Getting an OPEL!!!");
        jan_kowalski.getCar(opel);

        System.out.printf("I have %.2f  of money  after buying an opel\n", jan_kowalski.getAccountValue());
        System.out.print("My car is: ");
        System.out.println(jan_kowalski.automobile.getManufacturer() +' '+ jan_kowalski.automobile.getFuelType());
        System.out.println(opel.getVendor());
        System.out.println(HujwejMejt10.getVendor());
        System.out.println(opel.price);
        System.out.println(HujwejMejt10.price);

        Car VolksWagen = new Car("Volkswagen", 90000.00, "Petrol", "GA2141L");

        Device device = new Phone("LG", 5.5); // this is to simple, we need something more granular
        //An abstract for instance
        device.turnOn();
        try {
            jan_kowalski.sell();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(felek.toString());
        System.out.println(felek);
        System.out.println(jan_kowalski.pet);

        Phone iPhoneX = new Phone("Apple", 5.5);
        iPhoneX.price = 3500.00;

        Car Merc = new Car("Mercedes", 120000.00, "Gas", "GWE1341L");

        Human Marek_with_stuff = new Human(80.00);
        Marek_with_stuff.telephone = iPhoneX;
        Marek_with_stuff.automobile = Merc;
        Marek_with_stuff.setCash(100000.00);

        System.out.println("Marek's car: " + Marek_with_stuff.automobile.toString());
        System.out.println("Marek phone: " + Marek_with_stuff.telephone);

        Human Grazyna_without_stuff = new Human(60.00);
        Grazyna_without_stuff.setCash(250000.00);

        Marek_with_stuff.telephone.sell(Grazyna_without_stuff, Marek_with_stuff);
        Marek_with_stuff.automobile.sell(Grazyna_without_stuff, Marek_with_stuff);

        System.out.println("Grazyna car: " + Grazyna_without_stuff.automobile.toString());
        System.out.println("Grazyna phone: " + Grazyna_without_stuff.telephone);

        System.out.println("Marek's car: " + Marek_with_stuff.automobile);
        System.out.println("Marek phone: " + Marek_with_stuff.telephone);

        VolksWagen.sell(Grazyna_without_stuff, Marek_with_stuff);

        System.out.println();

        //grazyna_kowalska.automobile = jan_kowalski.automobile;

        //grazyna_kowalska.automobile = new Car("Mercedes", 120000.00, "Gas", "GWE1341L");
        //System.out.println(grazyna_kowalska.automobile);
        //System.out.println(jan_kowalski.automobile);
        //System.out.println(grazyna_kowalska.automobile.equals(jan_kowalski.automobile));
        //System.out.println(grazyna_kowalska.automobile.toString());
    }
}
