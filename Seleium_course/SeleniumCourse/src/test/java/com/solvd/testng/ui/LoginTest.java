package com.solvd.testng.ui;

import org.testng.annotations.*;

public class LoginTest {

    @BeforeTest
    public void loginToApplication() {
        System.out.println("Login to application");
    }

    @AfterTest
    public void logoutFromApplication() {
        System.out.println("Logout from application");
    }

    @Test(priority = 1, description = "This is first test")
    public void aTest1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2, description = "this is second test")
    public void aTest2() {
        System.out.println("Test 2");
    }

    @BeforeMethod
    public void connectToDB() {
        System.out.println("Connect to DB");
    }

    @AfterMethod
    public void disconnectFromDB() {
        System.out.println("Disconnect from DB");
    }
}
