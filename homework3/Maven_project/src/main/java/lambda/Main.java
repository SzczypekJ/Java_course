package lambda;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // Testing IAdd with lambda
        IAdd a = (x, y) -> x + y;
        System.out.println("Result of adding 5 and 5 is: " + a.add(5, 5));
        int b = a.add(3, 5);
        System.out.println("Result of adding 3 and 5 is: " + b);

        // Testing ISubtract with lambda
        ISubtract sub = (x, y) -> x - y;
        System.out.println("Result of SUBSTRACT 5 and 5 is: " + sub.subtract(5, 5));
        int c = sub.subtract(3, 5);

        System.out.println("Result of SUBSTRACT 3 and 5 is: " + c);

        // Testng IMultiply with lambda
        IMultiply m = (x, y) -> x * y;
        System.out.println("Result of multiply 5 and 5 is: "+ m.multiply(5, 5));

        // Lambda with generics
        // Testing MyFunction - better approach than Three before because one function can make every thing like functions before
        MyFunction<Integer, Integer, Integer> betterAdd = (x, y) -> x + y;
        System.out.println("Result of adding 5 and 10 is: " + betterAdd.apply(5, 10));

        MyFunction<Integer, Double, Double> betterAdd2 = (x, y) -> x + y;
        System.out.println("Result of adding 3 and 2.5 is: " + betterAdd2.apply(3, 2.5));

        MyFunction<String, String, String> betterAdd3 = (x, y) -> x + y;
        System.out.println("Result of adding Jakub and Szczypek is: " + betterAdd3.apply("Jakub", "Szczypek"));

        MyFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        System.out.println("Result of multiply 5 and 5 is: " + multiply.apply(5, 5));

        // Testing Checking
        Checking<String> containsMyName = s -> s.contains("Jakub");
        System.out.println("Is in the String name 'Jakub'? " + containsMyName.check("Anna, Michal, Pawel, Ewa"));
        System.out.println("Is in the String name 'Jakub'? " + containsMyName.check("Anna, Michal, Jakub, Pawel, Ewa"));

        // Testing TransformIntToStr
        TransformIntToStr<Integer, String> newString = x -> "Number: " + x;
        System.out.println("Transforming 10 (int) to String" + newString.transform(10));

        // Testing Enums
        for (CreditCards card: CreditCards.values()) {
            System.out.println(card.getTitle());
            System.out.println(card.getDescription());
            System.out.println("===========");
        }

        for (Banks bank: Banks.values()) {
            System.out.println(bank.getName());
            System.out.println(bank.getCreditCards());
            System.out.println(bank.getDescription());
            System.out.println(bank.getMaxAmountOfMoney());
            System.out.println("===========");
        }

        for (Battery battery: Battery.values()) {
            System.out.println(battery.getPower());
            System.out.println("===========");
        }

        for (Laptop laptop: Laptop.values()) {
            System.out.println(laptop.getName());
            System.out.println(laptop.getBattery());
            System.out.println("===========");
        }

        // Extra task - 5 lambda functions from the java.util.function package
        // 1
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 5 even? " + isEven.test(5));
        System.out.println("Is 4 even? " + isEven.test(4));

        // 2
        Function<String, Integer> stringLength = x -> x.length();
        System.out.println("The lenght of 'Jakub' is: " + stringLength.apply("Jakub"));

        // 3
        BiFunction<Integer, Double, Double> biFunction = (x, y) -> x + y;
        System.out.println("The result of adding integer and double: " + biFunction.apply(5, 7.6));

        // 4
        BiPredicate<Integer, Integer> sumGreaterThan100 = (x, y) -> x + y > 100;
        System.out.println("Is 1 + 2 greater than 100? " + sumGreaterThan100.test(1, 2));
        System.out.println("Is 35 + 70 greater than 100? " + sumGreaterThan100.test(35, 70));

        // 5
        ToIntFunction<String> binaryToInt = binaryString -> Integer.parseInt(binaryString, 2);
        System.out.println("Binary '100' to int: " + binaryToInt.applyAsInt("100"));
        System.out.println("Binary '1111' to int: " + binaryToInt.applyAsInt("1111"));
        System.out.println("Binary '10101' to int: " + binaryToInt.applyAsInt("10101"));


        System.out.println("Acer has battery with: " + selectBattery(Laptop.ACER.getBattery()));
        System.out.println("Asus has battery with: " + selectBattery(Laptop.ASUS.getBattery()));




    }

    public static String selectBattery(Battery battery) {
        switch (battery) {
            case LOW_POWER:
                return "Low Power";
            case HIGH_POWER:
                return "High Power";
            default:
                return "Unknown Power";
        }
    }
}
