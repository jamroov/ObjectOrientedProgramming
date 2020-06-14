package com.company;

import com.company.Animals.FarmAnimal;
import com.company.Devices.DieselCar;
import com.company.Devices.ElectricVehicle;
import com.company.Devices.PetrolCar;
import com.company.buildings.Garage;
import com.company.database.Connector;

public class Main {

    public static void main(String[] args) throws Exception {
        Boolean result;
        Human stefan = new Human(80.0, "Stefan", "Iksinski");

        stefan.setCash(10.00);
        System.out.println(stefan.feed(4, 1.0));
        System.out.println(stefan.getCash());
        System.out.println(stefan.getWeight());
        System.out.println(stefan.toString());
        Connector.connect();
        Connector.executeSQL("select * from animals");

        FarmAnimal Helga = new FarmAnimal("Helga", "Pigus-maximus", 125.00, 849.00);
        Helga.feed();

        Human farmer = new Human(75.00, "John", "Doe");
        farmer.startFeeding(stefan, 1, 2.0);

        farmer.automobile = new DieselCar("Ursus", 150000.00, "GWE123456", 1992);
        System.out.println(farmer.automobile.toString());
        farmer.automobile.refuel();


        DieselCar audi = new DieselCar("Audi", 69000.00, "GDA 123456", 2004);
        PetrolCar passat = new PetrolCar("Volkswagen", 58456.00, "GKS 5678H", 2010);
        ElectricVehicle tesla = new ElectricVehicle("Tesla", 347000.00, "GD 12H87", 2018);
        DieselCar audi2 = new DieselCar("Audi", 69000.00, "GDA 123456", 2004);

        Human Marek = new Human(80.00, "Marek", "Nowak");
        Human Ania = new Human(80.00, "Ania", "Misztal");
        Human Kamil = new Human(80.00, "Kamil", "Heft");
        Human Zygmunt = new Human(80.00, "Zygmunt", "Frojdowicz");
        Human Heniek = new Human(80.00, "Henryk", "Michalak");

        Garage marekGarage = new Garage(4, Marek);
        Garage aniaGarage = new Garage(4, Ania);
        Garage kamilGarage = new Garage(4, Kamil);
        Garage zygmuntGarage = new Garage(4, Zygmunt);
        Garage heniekGarage = new Garage(4, Heniek);

        Marek.setCash(2000000.00);
        Ania.setCash(2000000.00);
        Kamil.setCash(2000000.00);
        Zygmunt.setCash(2000000.00);
        Heniek.setCash(2000000.00);

        Marek.getCar(tesla);
        result = Marek.automobile.sell(Ania, Marek);
        if (result)
            System.out.println("Succesfull transaction.");
        result = Ania.automobile.sell(Kamil, Ania);
        if (result)
            System.out.println("Succesfull transaction.");
        result = Kamil.automobile.haveSold(Kamil.getFullName(), Ania.getFullName());
        result = Kamil.automobile.sell(Zygmunt, Kamil);
        result = Zygmunt.automobile.sell(Heniek, Zygmunt);
        System.out.println(String.format("This car has had %d owners so far.", tesla.getNumOwners()));
        result = tesla.wasOwner(Marek.getFullName());
        if (result)
            System.out.println("Marek was an owner");
        result = tesla.isCurrOwner(Zygmunt.getFullName());
        if (result)
            System.out.println("");
        else
            System.out.println("Zygmunt ain't current owner");
        result = tesla.isCurrOwner(Heniek.getFullName());
        if (result)
            System.out.println("Heniek is the current owner.");
        tesla.printOwnerHistory();

        Connector.connect();
        Connector.getStatement().execute("select * from animals");
        Connector.executeSQL("select * from animals");

    }
}
