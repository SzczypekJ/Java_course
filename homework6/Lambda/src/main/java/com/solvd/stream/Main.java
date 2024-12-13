package com.solvd.stream;

import com.solvd.lambdas.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.stream().
                forEach(System.out::println);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(5);
        intList.add(10);
        intList.stream().map(x -> x * x).
                forEach(System.out::println);

        List<Integer> newList = intList.stream().
                map(x -> x * x).
                toList();
        System.out.println(newList);

        Person person = new Person("Jakub", 18);
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(new Person("Michal", 30));
        personList.add(new Person("David", 5));

        List<Integer> ages = personList.stream().
                map(x -> x.getAge()).
                collect(Collectors.toList());
        System.out.println(ages);

        List<Integer> agesUnder = personList.stream().
                map(x -> x.getAge()).
                filter(age -> age > 18).
                collect(Collectors.toList());
        System.out.println(agesUnder);

        personList.stream().
                filter(x -> x.getAge() < 25).
                forEach(System.out::println);

        personList.stream()
                .filter(x -> x.getName().contains("a"))
                .forEach(System.out::println);

        personList.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
    }
}
