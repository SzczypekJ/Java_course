package com.solvd.day5;

import io.restassured.http.ContentType;

import io.restassured.http.*;
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


public class ParsingXMLResponse {

    @Test
    public void textXMLResponse() {

        // approach 1
//        given()
//                .when()
//                .get("https://api.nbp.pl/api/exchangerates/tables/A/?format=xml")
//                .then()
//                .statusCode(200)
//                .header("Content-Type", "application/xml; charset=utf-8")
//                .body("ArrayOfExchangeRatesTable.ExchangeRatesTable.Table", equalTo("A"))
//                .body("ArrayOfExchangeRatesTable.ExchangeRatesTable.EffectiveDate", equalTo("2025-03-03"));

        // approach 2
        Response response = given()
                .when()
                .get("https://api.nbp.pl/api/exchangerates/tables/A/?format=xml");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=utf-8");

        XmlPath xmlPath = response.xmlPath();

        Assert.assertEquals(xmlPath.getString("ArrayOfExchangeRatesTable.ExchangeRatesTable.Table"),
                "A", "Table is not matching A");
        Assert.assertEquals(xmlPath.getString("ArrayOfExchangeRatesTable.ExchangeRatesTable.EffectiveDate"),
                "2025-03-03", "The data is mismatching");

        System.out.println("Lista walut:");
        int size = xmlPath.getList("ArrayOfExchangeRatesTable.ExchangeRatesTable.Rates.Rate").size();

        for (int i = 0; i < size; i++) {
            String concurrencyName = xmlPath.getString("ArrayOfExchangeRatesTable.ExchangeRatesTable.Rates.Rate[" + i + "].Currency");
            String concurrencyValue = xmlPath.getString("ArrayOfExchangeRatesTable.ExchangeRatesTable.Rates.Rate[" + i + "].Mid");
            System.out.println(concurrencyName + " - " + concurrencyValue);
        }

        List<String> rates = xmlPath.getList("ArrayOfExchangeRatesTable.ExchangeRatesTable.Rates.Rate");
        System.out.println(rates);

        List<String> allNames = xmlPath.getList("ArrayOfExchangeRatesTable.ExchangeRatesTable.Rates.Rate.Currency");

        if (allNames.contains("dolar amerykański")) {
            System.out.println("Dolar amerykański jest w rates");
        } else {
            System.out.println("Nie ma dolara amerykańskiego w rates");
        }
    }
}
