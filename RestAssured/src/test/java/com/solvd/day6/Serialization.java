package com.solvd.day6;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import io.restassured.http.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
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

public class Serialization {

    @Test(priority = 1)
    public void serialize() {

        Book book = new Book("Effective Java", "Joshua Bloch", "Programming", "9780134685991", 199.99);

        Response response = given()
                .contentType("application/json")
                .body(book)
                .when()
                .post("http://localhost:3000/books");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
