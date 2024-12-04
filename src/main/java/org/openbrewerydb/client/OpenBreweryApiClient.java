package org.openbrewerydb.client;

import io.restassured.response.Response;
import io.restassured.RestAssured;

public class OpenBreweryApiClient {

    public static Response searchBreweries(String url) {
        return RestAssured.given()
                .log().uri()
                .when()
                .get(url)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();
    }
}

