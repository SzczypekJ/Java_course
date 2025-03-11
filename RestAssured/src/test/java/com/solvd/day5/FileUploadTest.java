package com.solvd.day5;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class FileUploadTest {

    @Test
    public void uploadFile() {
        // Plik do przesłania
        File file = new File("C:\\Users\\Jakub\\Desktop\\STUDIA\\dodat\\Java_course\\RestAssured\\src\\test\\resources\\testfile.txt");

        // Wysyłanie pliku w multipart/form-data
        Response response = RestAssured.given()
                .multiPart("file", file)
                .when()
                .post("https://httpbin.org/post");


        Assert.assertEquals(response.getStatusCode(), 200, "Błąd przesyłania pliku!");

        System.out.println("Odpowiedź API: " + response.getBody().asString());
    }
}
