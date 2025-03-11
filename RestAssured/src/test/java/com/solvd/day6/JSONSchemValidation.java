package com.solvd.day6;

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

public class JSONSchemValidation {

    @Test
    public void jsonSchemaValidation() {

        given()
                .when()
                .get("http://localhost:3000/store")
                .then()
                .assertThat().body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath("jsonSchema.json"));
    }
}
