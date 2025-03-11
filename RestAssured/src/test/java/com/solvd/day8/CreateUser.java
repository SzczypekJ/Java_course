package com.solvd.day8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test(priority = 1)
    public void createUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

        String bearerToken = "";

        int id = given()
                .headers("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/users")
                .jsonPath().getInt("id");

        System.out.println("Id is: " + id);
        context.setAttribute("user_id", id);
    }
}
