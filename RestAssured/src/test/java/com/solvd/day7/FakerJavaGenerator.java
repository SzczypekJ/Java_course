package com.solvd.day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerJavaGenerator {

    @Test
    public void testGenerateData() {

        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String username = faker.name().username();
        String password = faker.internet().password();

        String phoneNumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().safeEmailAddress();

        System.out.println("Full Name: " + fullName);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);

    }
}
