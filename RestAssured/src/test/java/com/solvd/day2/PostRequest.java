package com.solvd.day2;

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

public class PostRequest {
    private static String userId1;
    private static String userId2;
    private static String userId3;
    private static String userId4;

    @Test(priority = 1)
    public void testPostUsingHashMap() {
        HashMap data = new HashMap();
        data.put("name", "Jakub");
        data.put("location", "France");
        data.put("phone", "123456");

        List<String> coursesList = new ArrayList<String>();
        coursesList.add("Java");
        coursesList.add("Python");
        coursesList.add("C++");
        data.put("courses", coursesList);


        userId1 = given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("http://localhost:3000/students")

        .then()
                .statusCode(201)
                .body("name", equalTo("Jakub"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Python"))
                .body("courses[2]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .extract()
                .path("id");

    }

    @Test(priority = 2)
    public void deleteUser() {
        given()

        .when()
                .delete("http://localhost:3000/students/" + userId1)

        .then()
                .statusCode(200);
    }


    @Test(priority = 3)
    public void testPostUsingOrgJsonLibrary() {
        JSONObject data = new JSONObject();

        data.put("name", "Jakub");
        data.put("location", "France");
        data.put("phone", "123456");
        JSONArray courses = new JSONArray();
        courses.put("Java");
        courses.put("Python");
        courses.put("C++");
        data.put("courses", courses);


        userId2 = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Jakub"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Python"))
                .body("courses[2]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .extract()
                .path("id");

    }

    @Test(priority = 4)
    public void deleteUser2() {
        given()

                .when()
                .delete("http://localhost:3000/students/" + userId2)

                .then()
                .statusCode(200);
    }


    @Test(priority = 5)
    public void testPostUsingPOJO() {

        Student student = new Student();
        student.setName("Jakub");
        student.setLocation("France");
        student.setPhone("123456");
        List<String> coursesList = new ArrayList<>();
        coursesList.add("Java");
        coursesList.add("Python");
        coursesList.add("C++");
        student.setCourses(coursesList);

        userId3 = given()
                .contentType("application/json")
                .body(student)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Jakub"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Python"))
                .body("courses[2]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .extract()
                .path("id");

    }

    @Test(priority = 6)
    public void deleteUser3() {
        given()

                .when()
                .delete("http://localhost:3000/students/" + userId3)

                .then()
                .statusCode(200);
    }


    @Test(priority = 7)
    public void testPostUsingExternalJSONFile() throws FileNotFoundException {

        File file = new File(".\\src\\test\\resources\\student.json");

        FileReader fileReader = new FileReader(file);

        JSONTokener jt = new JSONTokener(fileReader);

        JSONObject data = new JSONObject(jt);

        userId4 = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Jakub"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Python"))
                .body("courses[2]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .extract()
                .path("id");

    }

    @Test(priority = 8)
    public void deleteUser4() {
        given()

                .when()
                .delete("http://localhost:3000/students/" + userId4)

                .then()
                .statusCode(200);
    }
}
