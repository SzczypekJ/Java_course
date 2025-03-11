package com.solvd.day7;

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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authentications {

//    Dwa testy niżej pokazują jak użyć Basic authentication
    @Test(priority = 1)
    public void testBasicAuthentication() {

        Response response = given()
                .auth().basic("admin", "admin123")
                .when()
                .get("http://localhost:3000/users");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);

    }

    @Test(priority = 2)
    public void testBasicAuthHttpBin() {
        given()
                .auth().basic("user", "pass")
                .when()
                .get("https://httpbin.org/basic-auth/user/pass")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }


//    Dwa testy niżej pokazują digest authentication
    @Test(priority = 3)
    public void testBasicAuthenticationDigest() {

        Response response = given()
                .auth().digest("admin", "admin123")
                .when()
                .get("http://localhost:3000/users");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);

    }

    @Test(priority = 4)
    public void testBasicAuthHttpBinDigest() {
        given()
                .auth().digest("user", "pass")
                .when()
                .get("https://httpbin.org/basic-auth/user/pass")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }


    //    Dwa testy niżej pokazują preemtive authentication
    @Test(priority = 5)
    public void testPreemtiveAuthentication() {

        Response response = given()
                .auth().preemptive().basic("admin", "admin123")
                .when()
                .get("http://localhost:3000/users");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);

    }

    @Test(priority = 6)
    public void testPreemtiveAuthHttpBinDigest() {
        given()
                .auth().preemptive().basic("user", "pass")
                .when()
                .get("https://httpbin.org/basic-auth/user/pass")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }

    @Test(priority = 7)
    public void bearerTokenAuthentication() {
        String token = "";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://localhost:3000/users")
                .then()
                        .statusCode(200)
                                .log().all();
//
//        System.out.println("Status Code: " + response.getStatusCode());
//        System.out.println("Response Body: " + response.getBody().asString());
//
//        response.then().statusCode(200);
    }

//    Niżej nie mam tych kluczy ale jakbym je miał to powinno to zadziałać
//    @Test(priority = 8)
//    public void testOAuth1Authentication() {
//
//        Response response = given()
//                .auth()
//                .oauth(
//                        "your_consumer_key",    // Consumer Key
//                        "your_consumer_secret", // Consumer Secret
//                        "your_access_token",    // Access Token
//                        "your_token_secret"     // Token Secret
//                )
//                .when()
//                .get("https://api.example.com/protected-resource");
//    }
//
    @Test(priority = 9)
    public void testOAuth2Authentication() {
        String token = ""; //Ten sam token co do baerer

        Response response = given()
                .auth()
                .oauth2(token)
                .when()
                .get("http://localhost:3000/users"); // Zamień na swój endpoint

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }
}
