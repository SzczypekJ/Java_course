package com.solvd.day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void getUser(ITestContext context) {
        String id = (String) context.getAttribute("user_id"); // Pobieramy ID z kontekstu

        String bearerToken = "your_token_here";

        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .pathParam("id", id)
                .when()
                .get("http://localhost:3000/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

        System.out.println("User data retrieved successfully.");
    }
}
