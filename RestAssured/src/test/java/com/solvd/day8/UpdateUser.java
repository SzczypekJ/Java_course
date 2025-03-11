package com.solvd.day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test(priority = 3, dependsOnMethods = "getUser")
    public void updateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active");

        String bearerToken = "your_token_here";
        String id = (String) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .body(data.toString())
                .when()
                .put("http://localhost:3000/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

        System.out.println("User updated successfully.");
    }
}
