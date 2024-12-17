package com.solvd.testng.ui;

import org.testng.annotations.*;

@Test(groups = {"user-registration"})
public class Groups {

    @Test(priority = 1, groups = {"regression"})
    public void atest1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2, groups = {"regression"})
    public void tbest2() {
        System.out.println("Test 2");
    }

    @Test(groups = {"regression", "smoke"})
    public void tbest3() {
        System.out.println("Test 3");
    }

    @Test(groups = {"smoke"})
    public void tbest4() {
        System.out.println("Test 4");
    }
}