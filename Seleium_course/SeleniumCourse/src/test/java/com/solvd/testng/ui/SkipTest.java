package com.solvd.testng.ui;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest {

    @Test(enabled = false)
    public void skipTest1() {
        System.out.println("Skip Test 1 - it's not completed");
    }

    @Test
    public void skipTest2() {
        System.out.println("Skip Test 2 - it's completed");
        throw new SkipException("Skip Test 2 - it's completed");
    }

    @Test()
    public void Test2() {
        System.out.println("This test is completed");
    }
}
