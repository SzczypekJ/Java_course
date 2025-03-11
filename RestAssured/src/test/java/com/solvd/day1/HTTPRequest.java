package com.solvd.day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class HTTPRequest {

    public int id;

    @Test(priority = 1)
    public void getUsers() {
        given()

        .when()
                .get("https://reqres.in/api/users?page=2")

        .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }


    @Test(priority = 2)
    public void createUser() {

        HashMap hm = new HashMap<>();
        hm.put("name", "Jakub");
        hm.put("job", "programmer");

        id = given()
            .contentType("application/json")
            .body(hm)

        .when()
            .post("https://reqres.in/api/users")
            .jsonPath().getInt("id");

//        .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        HashMap hm = new HashMap<>();
        hm.put("name", "Jakub");
        hm.put("job", "update job");

        given()
                .contentType("application/json")
                .body(hm)

        .when()
                .put("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"updateUser"})
    public void deleteUser() {
        given()

        .when()
                .delete("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(204)
                .log().all();
    }
}
