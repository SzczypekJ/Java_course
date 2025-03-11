package com.solvd.day3;

import io.restassured.http.ContentType;

import io.restassured.http.*;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Headers {

    // Test for validation the headers
    @Test(priority = 1)
    public void headersTest() {

        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws");


    }

    // How to get info about the headers
    @Test(priority = 2)
    public void getHeadersTest() {

        Response response = given()
                .when()
                .get("https://www.google.com/");

        // get single header info
        String header = response.getHeader("Content-Type");
        System.out.println("The value of Content-type header is: " + header);


        // get all headers info

        io.restassured.http.Headers myHeaders = response.getHeaders();
        for (Header hd : myHeaders) {
            System.out.println(hd.getName() + ": " + hd.getValue());
        }
    }
}
