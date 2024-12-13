package com.solvd.lambdas;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Begining of the lambda functions
        Jakub jakub = new Jakub();
        String greeting = jakub.speak("I am Jakub");
        System.out.println(greeting);

        ISpeak<String> daniel = new ISpeak<String>() {
            @Override
            public String speak(String s) {
                return s;
            }
        };

        String result = daniel.speak("Hi, now I am Daniel");
        System.out.println(result);

        ISpeak<String> Anna = (x) -> x;
        System.out.println(Anna.speak("I am Anna"));

        IChangeIntegersToStrings<String, Integer> firstTry = (x) -> String.valueOf(x);;
        Object result1 = firstTry.changeIntToString(10);

        // Checking if the result is String
        if (result1 instanceof String) {
            System.out.println("Result is an instance of String: " + result1);
        } else {
            System.out.println("Result is not an instance of String");
        }

        IAddFloatAndInteger<Integer, Float> resultOfAdding = (x, y) -> x + y;
        System.out.println(resultOfAdding.addFloatAndInteger(10, 15.5F));

        // Comparator
        Set<Student> set = new TreeSet<>((student1, student2) -> student1.getAge() - student2.getAge());

        Set<Student> set2 = new TreeSet<>((student1, student2) -> student1.getName().compareTo(student2.getName()));

        // ENUMS
        Laptop macbook = Laptop.MACBOOK;
        Laptop lenovo = Laptop.LENOVO;

        macbook.checkTheBattery();
        lenovo.checkTheBattery();

        System.out.println("Laptop: " + macbook.getName() + ", Price: " + macbook.getPrice());
        System.out.println("Laptop: " + lenovo.getName() + ", Price: " + lenovo.getPrice());

        for (CreditCard creditCard: CreditCard.values()) {
            System.out.println(creditCard.getName() + " " + creditCard.getTypeOdCard() + " " + creditCard.getAmount());
        }

        Bank alior = Bank.ALIOR_BANK;
        Bank mBank = Bank.M_BANK;

        System.out.println(alior.getName() + ": Can take a loan? " + alior.checkIfICanTookALoan());
        System.out.println(mBank.getName() + ": Can take a loan? " + mBank.checkIfICanTookALoan());

        Phone phone = Phone.ONEPLUS;
        Phone phone2 = Phone.SAMSUNG;
        Phone phone3 = Phone.IPHONE;

        compare(phone, phone2);
        compare(phone, phone3);
        compare(phone2, phone3);

        printTheNameOfLaptop(macbook);
        printTheNameOfLaptop(lenovo);
    }

    public static void compare(Phone phone1, Phone phone2) {
        if (phone1.getBattery().getPower() > phone2.getBattery().getPower()) {
            System.out.println("The battery of phone " + phone1.getName() + " is bigger than the battery of phone " + phone2.getName());
        } else {
            System.out.println("The battery of phone " + phone2.getName() + " is bigger than the battery of phone " + phone1.getName());
        }
    }

    public static void printTheNameOfLaptop (Laptop laptop) {
        switch (laptop) {
            case LENOVO -> System.out.println("Lenovo");
            case MACBOOK -> System.out.println("Macbook");
        }
    }
}