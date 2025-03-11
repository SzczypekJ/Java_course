package com.solvd.day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test(priority = 4, dependsOnMethods = "updateUser")
    public void deleteUser(ITestContext context) {
        String bearerToken = "your_token_here";
        String id = (String) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .pathParams("id", id)
                .when()
                .delete("http://localhost:3000/users/{id}")
                .then()
                .statusCode(200) // JSON Server zwraca 200 zamiast 204
                .log().all();

        System.out.println("User deleted successfully.");
    }
}
