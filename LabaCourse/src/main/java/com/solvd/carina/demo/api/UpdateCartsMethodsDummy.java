package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/carts/1", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/carts/_put/rs.json")
@RequestTemplatePath(path = "api/carts/_put/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateCartsMethodsDummy extends AbstractApiMethodV2 {

    public UpdateCartsMethodsDummy() {
        super("api/carts/_put/rq.json",
                "api/carts/_put/rs.json",
                "api/carts/_put/cart.properties");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
