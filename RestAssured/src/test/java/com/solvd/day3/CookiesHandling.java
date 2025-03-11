package com.solvd.day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesHandling {

    @Test(priority = 1)
    public void testCookies() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .log().all();
    }

    @Test(priority = 2)
    public void getCookiesInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");

        // get single cookie info
        String cookieValue = response.getCookie("AEC");
        System.out.println("Value of cookie is ====> " + cookieValue);

        // get all cookies info
        Map<String, String> allCookies = response.getCookies();
        for (Map.Entry<String, String> entry : allCookies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
