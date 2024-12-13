package com.solvd.reflection;

import com.solvd.stream.Person;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class person = Person.class;

        Person p = new Person("Jakub", 23);

        Class person2 = p.getClass();

        Class person3 = Class.forName("com.solvd.stream.Person");

        // Call method to print class details
        printMethods(person);

        // Modify the private field "age"
        Field field = person.getDeclaredField("age"); // getDeclaredField allows access to private fields
        field.setAccessible(true); // Allow modification of private fields
        field.set(p, 10); // Set a new value for the field
        System.out.println("Modified age: " + p.getAge());

        // Create a new instance using a constructor with arguments
        Constructor constructor = person.getConstructor(String.class, int.class);
        Person personNew = (Person) constructor.newInstance("Michal", 30);
        System.out.println("New instance: " + personNew.getName() + ", age: " + personNew.getAge());

        Method getNameMethod = person.getMethod("getName");
        String name = (String) getNameMethod.invoke(personNew);
        System.out.println("Name retrieved using reflection: " + name);

    }

    public static void printMethods(Class cl) {
        // Print methods
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Number of parameters: " + method.getParameterTypes().length);
        }

        // Print constructors
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
            System.out.println("Number of parameters: " + constructor.getParameterTypes().length);
            System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter: " + parameter.getName());
                System.out.println("Parameter type: " + parameter.getType());
            }
        }

        // Print fields
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
            System.out.println("Field type: " + field.getType());
        }
    }
}
