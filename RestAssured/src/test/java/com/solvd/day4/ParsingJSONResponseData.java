package com.solvd.day4;

import io.restassured.http.ContentType;

import io.restassured.http.*;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {

    @Test(priority = 1)
    void testJsonResponse() {

        // Approach 1
//        given()
//                .contentType(ContentType.JSON)
//        .when()
//                .get("http://localhost:3000/store")
//        .then()
//                .statusCode(200)
//                .header("Content-Type", "application/json")
//                .body("books[2].title", equalTo("Atomic Habits"));

        // Approach 2
        Response response = given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/store");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json");

        // Verifying body using jsonPath()
        Assert.assertEquals(response.jsonPath().get("books[2].title").toString(), "Atomic Habits");

    }

    @Test(priority = 2)
    public void testJsonResponseBodyData() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        JSONObject jsonObject = new JSONObject(response.asString());

        for (int i=0; i < jsonObject.getJSONArray("books").length(); i++) {

            String bookTitle = jsonObject.getJSONArray("books")
                                          .getJSONObject(i).getString("title");

            System.out.println(bookTitle);
        }

        boolean status = false;
        for (int i=0; i < jsonObject.getJSONArray("books").length(); i++) {

            String bookTitle = jsonObject.getJSONArray("books")
                    .getJSONObject(i).getString("title");

            if (bookTitle.equals("Atomic Habits")) {
                status = true;
                break;
            }
        }

        Assert.assertTrue(status, "We haven't found the book title");


        // 3rd approach using jsonPath() -probably the best approach
        List<String> bookTitles = response.jsonPath().getList("books.title");

        bookTitles.forEach(System.out::println);

        Assert.assertTrue(bookTitles.contains("Atomic Habits"), "We haven't found the book title");

    }

    @Test(priority = 3)
    public void testTotalPriceOfTheBooks() {
        Response response = given()
        .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        JSONObject jsonObject = new JSONObject(response.asString());

        double totalPrice = 0;
        for (int i = 0; i < jsonObject.getJSONArray("books").length(); i++) {
            double price = jsonObject.getJSONArray("books").getJSONObject(i).getDouble("price");

            totalPrice += price;
        }

        System.out.println("Total price is:" + totalPrice);
        Assert.assertEquals(totalPrice, 629.95,  "The total price is incorrect");
    }
}
