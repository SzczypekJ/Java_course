package com.solvd.carina.demo;

import com.solvd.carina.demo.api.UpdateCartsMethodsDummy;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DummyUpdateCartsTest implements IAbstractTest {

    @Test
    public void testUpdateCartWithSingleProduct() {

        UpdateCartsMethodsDummy apiMethod = new UpdateCartsMethodsDummy();

        apiMethod.setProperties("api/carts/_put/cart.properties");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }
}
