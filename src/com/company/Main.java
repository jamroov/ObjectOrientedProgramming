package com.company;

import com.company.Devices.Car;
import com.company.Devices.Phone;

public class Main {

    public static void main(String[] args) {

        Animal burek = new Animal("Dog", 10.5);
        burek.name = "Burek";
        Car opel = new Car("Opel", 72000.00, "Diesel");

        Phone HujwejMejt10 = new Phone("Hujwej", 5.6);
        HujwejMejt10.price = 1099.0;

        Human jan_kowalski = new Human();
        jan_kowalski.firstName = "Jan";
        jan_kowalski.lastName = "Kowalski";
        jan_kowalski.pet = burek;
        jan_kowalski.telephone = HujwejMejt10;

        jan_kowalski.pet.name = "Burek";
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
           System.out.printf("%s\n", salary);
           count++;
        }
        System.out.printf("I have %.2f of money  before buying an opel\n", jan_kowalski.getAccountValue());
        System.out.println("Getting an OPEL!!!");
        jan_kowalski.getCar(opel);

        System.out.printf("I have %.2f  of money  after buying an opel\n", jan_kowalski.getAccountValue());
        System.out.print("My car is: ");
        System.out.println(jan_kowalski.automobile.getManufacturer() +' '+ jan_kowalski.automobile.getFuelType());
    }
}
