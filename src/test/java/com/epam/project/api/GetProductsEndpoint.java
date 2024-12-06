package com.epam.project.api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.project.api.Endpoints.PRODUCTS;
import static com.epam.project.framework.loging.Log.logInfoMessage;
import static com.epam.project.framework.properties.EnvironmentProperty.getEnv;
import static io.restassured.RestAssured.given;

public class GetProductsEndpoint {

    @Test
    public void verifyGetProducts() {
        logInfoMessage("Starting get products test");
        Response response = given()
                .baseUri(getEnv())
                .header("Content-Type", "application/json")
                .when()
                .get(PRODUCTS);
        logInfoMessage("Response: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code");
    }
}
