package stream.reflection;

import lambda.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
// represent our class like object of class Class
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cl = Student.class;
        LOGGER.info("Class: " + cl.toString());

        Student student = new Student("Ivan");
        LOGGER.info("Student instance class: " + student.getClass().toString());

        Constructor constructor = cl.getDeclaredConstructor(String.class);
        LOGGER.info(constructor.toString());
        Student student2 = (Student) constructor.newInstance("Anna");
        LOGGER.info("Created student: " + student2.toString());

        LOGGER.info("Inspecting constructors:");
        for (Constructor<?> constructornew : cl.getConstructors()) {
            LOGGER.info("Constructor with " + constructornew.getParameterCount() + " parameters");
            for (Parameter parameter : constructornew.getParameters()) {
                LOGGER.info("Parameter name: " + parameter.getName());
                LOGGER.info("Parameter type: " + parameter.getType());
                LOGGER.info("==========");
            }
        }

        Class<NewStudent> clazz = NewStudent.class;
        Constructor<?>[] constructors2 = clazz.getConstructors();

        for (Constructor<?> newconstructor : constructors2) {
            LOGGER.info("Constructor with " + newconstructor.getParameterCount() + " parameters");
            Parameter[] parameters = newconstructor.getParameters();

            for (Parameter parameter : parameters) {
                LOGGER.info("Parameter name: " + parameter.getName());
                LOGGER.info("Parameter type: " + parameter.getType());
                LOGGER.info("==========");
            }
        }

        LOGGER.info("Inspecting methods:");
        for (Method method : cl.getDeclaredMethods()) {
            LOGGER.info("Method name: " + method.getName());
            LOGGER.info("Return type: " + method.getReturnType());
            LOGGER.info("==========");
        }

        Method method = cl.getMethod("print", String.class);
        method.invoke(student2, "hello");

        LOGGER.info("Inspecting fields:");
        for (Field field : cl.getDeclaredFields()) {
            LOGGER.info("Field name: " + field.getName());
        }

        // STREAMING !!!!! -Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.(map, filter, foreach, *reduce)
        // map
        // filter
        // foreach
        // reduce
        List<NewStudent> list = new ArrayList<>();
        list.add(new NewStudent("Jakub", 20));
        list.add(new NewStudent("Anna", 30));
        list.add(new NewStudent("Ivan", 16));

        // 1
        list.stream().
                map(x -> x.getName()).
                forEach(y -> LOGGER.info("List of names: " + y));

        // 2
        list.stream().
                map(x -> x.getAge()).
                forEach(y -> LOGGER.info("List of ages: " + y));

        //3
        List<String> names = list.stream().
                map(x -> x.getName()).
                collect(Collectors.toList());

        LOGGER.info("Names: " + names);

        // the same like line above
        List<String> names2 = new ArrayList<>();
        for (NewStudent newStudent : list) {
            names2.add(student.getName());
        }
        LOGGER.info("Names2 is the same like Names: " + names2);

        // 4
        list.stream().
                filter(x -> x.getAge() > 18).
                map(x -> x.getName()).
                forEach(y -> LOGGER.info(y));

        // 5
        int sum = list.stream().
                map(x -> x.getAge()).
                reduce(0, (x, y) -> x + y);
        LOGGER.info("Sum of ages: " + sum);

        // 6
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(Laptop.ACER);
        laptops.add(Laptop.ASUS);
        laptops.stream().
                map(x -> x.getBattery()).
                forEach(y -> LOGGER.info("Batteries in Enum Laptop: " + y));

        // 7
        laptops.stream().
                filter(x -> x.getBattery() == Battery.HIGH_POWER).
                map(x -> x.getName()).
                forEach(y -> LOGGER.info("Names of Laptops which has high power batteries: " + y));

        // 8
        List<Banks> banks = new ArrayList<>();
        banks.add(Banks.ALIOR_BANK);
        banks.add(Banks.MILENIUM);
        banks.add(Banks.MBANK);
        banks.add(Banks.PEKAO);
        List<String> nameOfBanks = banks.stream().
                filter(x -> x.getMaxAmountOfMoney() > 1500).
                map(x -> x.getName()).
                collect(Collectors.toList());
        LOGGER.info("NameOfBanks which can have more than 1500 money in Bank account : " + nameOfBanks);

        // 9
        list.stream()
                .map(NewStudent::getName)
                .distinct()
                .forEach(name -> LOGGER.info("Distinct names: " + name));

        // 10
        list.stream()
                .map(NewStudent::getName)
                .sorted()
                .forEach(name -> LOGGER.info("Sorted names: " + name));

        // 11
        list.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                .map(NewStudent::getName) // Map to names
                .forEach(name -> LOGGER.info("Sorted names by age: " + name));



        // 4 Levels of Logger
        // debug
        // info
        // warning
        // error
        // Testing Logger - not showing debug information's due to log4j2.properties
        LOGGER.debug("Debug message for testing");
        LOGGER.info("Info message for testing");
        LOGGER.warn("Warning message for testing");
        LOGGER.error("Error message for testing");
        scroll();
    }

    public static void scroll() {
        LOGGER.debug("Scroll from");
        int a = 5+ 6;
        LOGGER.debug("Scroll from");
        LOGGER.debug("Scroll from");
        LOGGER.debug("Scroll from");
    }
}