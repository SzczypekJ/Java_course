package com.solvd.day3;
import io.restassured.http.ContentType;
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

public class PathAndQueryParameters {

    @Test
    public void testQueryAndPathParameters() {
        given()
                .pathParam("mypath", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)
                .when()
                .get("https://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();
    }

}
