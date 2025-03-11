package com.solvd.carina.demo;

import com.solvd.carina.demo.api.GetCartsMethodsDummy;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyGetCartsTest {

    @Test
    public void testGetCart() {
        GetCartsMethodsDummy getCarts = new GetCartsMethodsDummy();
        getCarts.callAPIExpectSuccess();
        getCarts.validateResponse();
        getCarts.validateResponseAgainstSchema("api/carts/_get/rs.schema");

        String jsonResponse = getCarts.callAPI().asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);

        Assert.assertEquals(jsonPath.getInt("id"), 1, "Cart ID is incorrect");
        Assert.assertEquals(jsonPath.getInt("userId"), 33, "User ID is incorrect");
        Assert.assertEquals(jsonPath.getDouble("total"), 103774.85, "Total amount is incorrect");

        Assert.assertEquals(jsonPath.getInt("products[0].id"), 168, "Id of first product is incorrect");
        Assert.assertEquals(jsonPath.getDouble("products[1].price"), 1999.99, "Price of second product is incorrect");
    }
}
