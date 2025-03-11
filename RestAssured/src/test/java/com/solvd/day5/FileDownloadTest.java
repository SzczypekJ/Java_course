package com.solvd.day5;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.http.*;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FileDownloadTest {

    @Test
    public void downloadFile() throws IOException {
        // Przykładowy plik do pobrania
        String fileUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";

        Response response = RestAssured.get(fileUrl);

        Assert.assertEquals(response.getStatusCode(), 200, "Błąd pobierania pliku!");

        // Zapis do pliku lokalnego
        FileUtils.copyURLToFile(new URL(fileUrl), new File("C:\\Users\\Jakub\\Desktop\\STUDIA\\dodat\\Java_course\\RestAssured\\src\\test\\resources\\downloaded_file.pdf"));
        System.out.println("Plik został pobrany.");
    }
}
