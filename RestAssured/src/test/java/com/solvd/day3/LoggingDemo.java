package com.solvd.day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {

    @Test(priority = 1)
    public void testLogs() {

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all();
                // .log().body(); - only for body
                // .log().cookies(); -only for cookies
                // .log().headers(); - only headers
                // .log().all(); - shows everything
    }
}
