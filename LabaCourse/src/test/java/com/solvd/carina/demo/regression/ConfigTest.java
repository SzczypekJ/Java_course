package com.solvd.carina.demo.regression;

import com.zebrunner.carina.utils.config.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigTest {

    @Test
    public void testApiUrl() {
        String apiUrl = Configuration.getRequired("api_url");
        System.out.println("API URL: " + apiUrl);
        Assert.assertEquals(apiUrl, "https://dummyjson.com", "API URL is incorrect!");
    }
}
