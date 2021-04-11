package com.company;

import com.company.Animals.*;
import com.company.Annotations.ObjectToSql;
import com.company.Devices.*;
import com.company.World.CountryEnum;
import com.company.World.CountryHashMap;
import com.company.buildings.Garage;
import threads.CallableCounter;
import threads.RunnableCounter;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Boolean result;
        Human stefan = new Human(80.0, "Stefan", "Iksinski", Gender.MALE);

        stefan.setCash(10.00);
        System.out.println(stefan.feed(4.0, 1.0));
        System.out.println(stefan.getCash());
        System.out.println(stefan.getWeight());

        //Connector.connect();
        //Connector.executeSQL("select * from animals");

        FarmAnimal Helga = new FarmAnimal("Helga", "Pigus-maximus", 125.00, 849.00, Gender.FEMALE, foodType.PLANTS);
        Helga.feed();

        Pet Azor = new Pet("dog", 25.00, "Azor", 125.0, Gender.MALE, foodType.ANYTHING);
        stefan.pet = Azor;

        System.out.println("Azor's weight: " + stefan.pet.getWeight());
        System.out.println("Feeding...");
        stefan.pet.feed();
        System.out.println("Azor's weight: " + stefan.pet.getWeight());
        System.out.println("Walking...");
        stefan.pet.walk();
        System.out.println("Azor's weight: " + stefan.pet.getWeight());

        Human farmer = new Human(75.00, "John", "Doe", Gender.MALE);
        farmer.startFeeding(stefan, 1.0, 2.0);

        Phone Iphone = new Phone("Apple", 5.4, 2019, 3499.00, OperatingSystem.iOS);
        System.out.println(Iphone.toString());
        Iphone.installAnApp(new Application("Fruit Ninja", 1.0, 19.49));

        Application subwaySurfers = new Application("Subway Surfers", 2.4, 5.49);
        Iphone.installAnApp(subwaySurfers.name, subwaySurfers.version, subwaySurfers.price);

        Iphone.installAnApp(new Application("Fruit Ninja", 1.0, 19.49));
        Iphone.installAnApp(new Application("Fruit Ninja 2", 1.0, 19.49));
        Iphone.installAnApp(new Application("Asphalt", 3.0, 10.49));
        Iphone.installAnApp(new Application("Tetris", 33.0, 1.49));
        Iphone.installAnApp(new Application("Jungle Speed", 3.4, 6.49));

        Set<Application> iphonesApps = Iphone.getAllApps();
        Iphone.printAllAppsOrdered("name");
        Iphone.printAllAppsOrdered("price");

        Car Ursus = new DieselCar("Ursus", 150000.00, "GWE123456", 1992, "C-60");
        Car UrsussClone = new DieselCar("Ursus", 150000.00, "GWE123456", 1992, "C-360");

        System.out.println("Two cars, same fields using equals():");
        System.out.println(Ursus.equals(UrsussClone));

        System.out.println(Azor);
        System.out.println(UrsussClone);

        System.out.println(Azor.toString());
        System.out.println(stefan.toString());
        System.out.println(Ursus.toString());
        stefan.telephone = new Phone("Samsung", 5.4, 2019, 1249.00, OperatingSystem.ANDROID);
        System.out.println(stefan.telephone.toString());

        farmer.setSalary(5350.00);
        farmer.buyCar(Ursus);
        farmer.increaseSalary(568.00);
        //farmer.setAutomobile(Ursus);
        Car FarmersCar = farmer.getAutomobile();
        FarmersCar.refuel();
        System.out.println(FarmersCar.toString());


        DieselCar audi = new DieselCar("Audi", 69000.00, "GDA 123456", 2004, "Audi A3");
        PetrolCar passat = new PetrolCar("Volkswagen", 58456.00, "GKS 5678H", 2010, "Passat B5");
        ElectricVehicle tesla = new ElectricVehicle("Tesla", 347000.00, "GD 12H87", 2018, "Tesla Model S");
        DieselCar audi2 = new DieselCar("Audi", 69000.00, "GDA 123456", 2004, "Audi A4");

        Human Marek = new Human(80.00, "Marek", "Nowak", Gender.MALE);
        Human Ania = new Human(80.00, "Ania", "Misztal", Gender.FEMALE);
        Human Kamil = new Human(80.00, "Kamil", "Heft", Gender.MALE);
        Human Zygmunt = new Human(80.00, "Zygmunt", "Frojdowicz", Gender.MALE);
        Human Heniek = new Human(80.00, "Henryk", "Michalak", Gender.MALE);

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

        Marek.setSalary(1250000.00);
        Ania.setSalary(1250000.00);
        Kamil.setSalary(1250000.00);
        Zygmunt.setSalary(1250000.00);
        Heniek.setSalary(1250000.00);
        Marek.buyCar(tesla);

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

        //Connector.connect();
        //Connector.getStatement().execute("select * from animals");
        //Connector.executeSQL("select * from animals");

        FarmAnimal Krasula = new FarmAnimal("Krasula", "Cow", 459.1, 1299.01, Gender.FEMALE, foodType.PLANTS);
        Pet Burek = new Pet("Dog", 11.2, "Burek", 50.00, Gender.MALE, foodType.MEAT);

        //Burek.save();
        //Krasula.save();

        Zygmunt.garage.storeCar(audi);
        Zygmunt.garage.storeCar(audi2);
        Zygmunt.garage.storeCar(tesla);
        Zygmunt.garage.storeCar(passat);

        Zygmunt.garage.printCarMapSorted();

        CountryHashMap thisCountryHashMap = new CountryHashMap();
        for (CountryEnum country : CountryEnum.values()) {
            thisCountryHashMap.addCountryToMap(country, country.area);
        }

        thisCountryHashMap.getAreaMax();
        thisCountryHashMap.getAreaMin();
        ManufacturersMap mapOfManuf = new ManufacturersMap();
        Car FordMondeo = new PetrolCar("Ford", 125000.00, "GWE14567", 2019, "Mondeo");

        mapOfManuf.addDeviceToMap(FordMondeo.getManufacturer(), FordMondeo);
        mapOfManuf.addDeviceToMap(audi.getManufacturer(), audi);
        mapOfManuf.addDeviceToMap(audi2.getManufacturer(), audi2);
        mapOfManuf.addDeviceToMap(Iphone.getVendor(), Iphone);

        ArrayList<Device> devices = mapOfManuf.getDevicesByManuf("Audi");
        if (devices != null) {
            System.out.println("Stuff in map of manufacturers");
            for (Device item : devices) {
                System.out.println(item.toString());
            }
        }

        devices = mapOfManuf.getDevicesByManuf("Ford");
        if (devices != null) {
            System.out.println("Stuff in map of manufacturers");
            for (Device item : devices) {
                System.out.println(item.toString());
            }
        }

        devices = mapOfManuf.getDevicesByManuf("Apple");
        if (devices != null) {
            System.out.println("Stuff in map of manufacturers");
            for (Device item : devices) {
                System.out.println(item.toString());
            }
        }
        List<Car> carList = new ArrayList<>();
        audi.setEngine(150.00, 2000.00, 1246);
        audi2.setEngine(150.00, 2500.00, 1446);
        Ursus.setEngine(250.00, 3500.00, 1566);

        carList.add(audi);
        carList.add(audi2);
        carList.add(Ursus);

        Comparator<Car> carComparator = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                Double car1_volume = car1.getEngineVolume();
                Double car2_volume = car2.getEngineVolume();
                return (int) (car1_volume - car2_volume);
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
        carList.sort(carComparator);

        Comparator<Animal> animalComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal animal1, Animal animal2) {
                return (int) (animal1.getWeight() - animal2.getWeight());
            }
        };

        List<Animal> animalList = new ArrayList<>();
        animalList.add(Krasula);
        animalList.add(Zygmunt);
        animalList.add(Azor);
        animalList.add(Helga);
        animalList.add(new Pet("Cat", 10.00, "Mruczek", 125.00, Gender.MALE, foodType.MEAT));
        animalList.add(Marek);
        System.out.println("animalList before sort");
        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
        //animalList.sort(animalComparator);
        //System.out.println("animalList after sort");
        //for (Animal animal : animalList) {
            //System.out.println(animal.toString());
        //}
        //System.out.println(updateSomeData("very new data indeed"));
        Runnable counter = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();
        //ScheduledExecutorService execService1 = Executors.newSingleThreadScheduledExecutor();
        //ScheduledExecutorService execService2 = Executors.newSingleThreadScheduledExecutor();

        //execService.schedule(counter, 1, TimeUnit.MICROSECONDS);
        //execService1.schedule(counter, 1, TimeUnit.MICROSECONDS);
        //execService2.schedule(counter, 1, TimeUnit.MICROSECONDS);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //executor.submit(new RunnableCounter());
        //executor.submit(new RunnableCounter());
        //executor.submit(new RunnableCounter());

        //executor.submit(new SubZero());
        //executor.submit(new Scorpion());

        RunnableCounter SubZero = new RunnableCounter();
        RunnableCounter Scorpion = new RunnableCounter();

        SubZero.finisher = () -> System.out.println("CHILLING!");
        Scorpion.finisher = () -> System.out.println("You've been scorpioed!");

        //executor.submit(SubZero);
        //executor.submit(Scorpion);
        CallableCounter cage = new CallableCounter();
        CallableCounter liuKang = new CallableCounter();

        cage.finisher = () -> System.out.println("You're locked up!");
        liuKang.finisher = () -> System.out.println("Liu Kang FTW!");

        System.out.println("Test 1");

        Future<Double> hpCage = executor.submit(cage);
        Future<Double> hpLiuKang = executor.submit(liuKang);

        System.out.println(hpCage.get());
        
        System.out.println("This is another change");
        
        System.out.println("Test 3");
        System.out.println(hpLiuKang.get());

        System.out.println("Test 4");
        if (hpCage.get() > hpLiuKang.get()) {
            cage.finisher.finishHim();
        } else {
            liuKang.finisher.finishHim();
        }
        executor.shutdown();
        System.out.println("Am on a new branch!");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach( (n) -> { System.out.println(n); } );

        //lambda to variable with interface
        CompareAnimals compare = (animal1, animal2) -> {
            if (animal1.getWeight() > animal2.getWeight()) {
                return animal1.getWeight();
            }
            else if (animal1.getWeight() < animal2.getWeight()) {
                return animal2.getWeight();
            }
            else {
                return 0.0;
            }
        };

        //lambda to variable with interface using ternary operator
        CompareAnimals compare2 = (animal1, animal2) ->
                animal1.getWeight() > animal2.getWeight() ? animal1.getWeight():animal2.getWeight();

        System.out.println(CompareAnimalWeight(Krasula, Burek, compare));
        System.out.println(CompareAnimalWeight(Marek, Ania, compare));
        System.out.println(CompareAnimalWeight(Marek, Ania, compare2));

        //Passing lambda to sort
        animalList.sort(((animal1, animal2) -> (int) (animal1.getWeight() - animal2.getWeight())));
        for (Animal item : animalList) {
            System.out.println(item.toString());
        }
        ObjectToSql sqlTool = new ObjectToSql();
        System.out.println(sqlTool.insert((Animal) Krasula));
        System.out.println(sqlTool.insert(tesla));
        System.out.println(sqlTool.insert(Iphone));
        System.out.println(sqlTool.insert(Marek));
    }

    //Method implementing CompareAnimals interface
    public static Double CompareAnimalWeight(Animal anim1, Animal anim2, CompareAnimals comparator) {
        return comparator.compare(anim1, anim2);
    }

    public static String updateSomeData(String newData) throws InterruptedException {
        System.out.println("Function: validation of data");
        Thread.sleep(20);
        System.out.println("Function: updating data to " + newData);
        Thread.sleep(20);

        Runnable later = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Function: looking for users that have to be notified");
                    Thread.sleep(2000);
                    System.out.println("Function: connecting to mail api (mailgun)");
                    Thread.sleep(500);
                    System.out.println("Function: Sending messages");
                    Thread.sleep(2000);
                    System.out.println("Info: Done! :D");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();
        execService.schedule(later, 1, TimeUnit.SECONDS);
        return "data was updated succesfully";
    }
}
