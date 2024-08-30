package exceptions;
import java.io.*;
import java.util.Scanner;
import java.io.FileReader;

public class Main {

    // try-catch with resources example - reading a text.txt file
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("The file contains following phrase: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Finally block");
        }

        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());

        try {
            doSmth(a);
        } catch (MyException ex) {
            System.out.println("Caught MyException: " + ex.getMessage());
        }

        int age = -5;
        try {
            validateAge(age);
        } catch (InvalidAgeException ex) {
            System.out.println(ex);
            if (ex.isNegativeAge()) {
                System.out.println("Negative age detected");
            }
            System.out.println(ex.suggestValidAgeRange());
        }

        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.next();

        validateName(name);

        String number = "123456789";
        validatePhoneNumber(number);

        String date = "10.10.2024";
        try {
            validateDate(date);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void doSmth (int a) throws MyException {
        if (a < 0) {
            // 1st way
//            try {
//                throw new MyException("My exception");
//            } catch (MyException e) {
//                System.out.println("a less than zero");
//                a = 0;
//            }
            // second way with throws in method declaration
            throw new MyException("My exception");
        }
        System.out.println("Continue with a = " + a);
    }

    public static void validateAge (int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age out of valid range", age);
        }
        System.out.println("Age is valid: " + age);
    }

    public static void validateName(String name) {
        try {
            InvalidNameException exception = new InvalidNameException(name);

            if (name.isEmpty() || !name.matches("[a-zA-Z]+") || name.length() >= 50) {
                throw exception;
            }
        } catch (InvalidNameException e) {
            System.out.println(e.suggestValidName(name));
        }
        System.out.println("The name is valid: " + name);
    }

    public static void validatePhoneNumber(String number) {
        try {
            InvalidPhoneNumberException exception = new InvalidPhoneNumberException(number);

            if (number.length() != 9) {
                throw exception;
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.suggestValidPhoneNumber(number));
        }
        System.out.println("The phone number is valid: " + number);
    }

    public static void validateDate (String date) throws InvalidDataException {
        InvalidDataException exception = new InvalidDataException(date);

        if (date == null || date.isEmpty()) {
            throw new InvalidDataException("Date is empty", date);
        } else if (!exception.validateDate(date)) {
            throw new InvalidDataException("Provide valid format for data: dd.MM.yyyy", date);
        }
        System.out.println("The date is valid: " + date);
    }

    // 2 ways to handle exceptions:
    // 1. try -> catch
    // 2. throws
}