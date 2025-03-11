package com.solvd.carina.demo;

import com.solvd.carina.demo.api.PostCartsMethodsDummy;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DummyPostCartsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "dummyOwner")
    public void testCreateCart() {
        LOGGER.info("Start testCreateCart()");

        PostCartsMethodsDummy api = new PostCartsMethodsDummy();

        api.setProperties("api/carts/cart.properties");

        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();

        api.validateResponse();
    }


    @Test
    @MethodOwner(owner = "dummyOwner")
    public void testCreateCartMissingSomeFields() {
        LOGGER.info("Start testCreateCartMissingSomeFields()");

        PostCartsMethodsDummy api = new PostCartsMethodsDummy();
        api.getProperties().remove("product1.id");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
