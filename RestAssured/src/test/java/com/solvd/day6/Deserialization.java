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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Deserialization {

    @Test
    public void testDeserialization() {

        Response response = given().
                contentType("application/json")
                .when()
                .get("http://localhost:3000/books");

        Book[] booksArray = response.getBody().as(Book[].class);
        List<Book> books = Arrays.asList(booksArray);

        for (Book book : books) {
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Cena: " + book.getPrice());
            System.out.println("-------------------------");
        }

        Assert.assertFalse(false, "Lista książek jest pusta!");
    }
}
