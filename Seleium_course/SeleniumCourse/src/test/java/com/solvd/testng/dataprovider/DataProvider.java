package com.solvd.testng.dataprovider;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]
                {
                        {"standard_user", "secret_sauce"},
                        {"locked_out_user", "secret_sauce"},
                        {"problem_user", "secret_sauce"},
                        {"performance_glitch_user", "secret_sauce"},
                        {"error_user", "secret_sauce"},
                        {"visual_user", "secret_sauce"}
                };
    }
}
