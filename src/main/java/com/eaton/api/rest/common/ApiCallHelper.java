package com.eaton.api.rest.common;

import static io.restassured.RestAssured.given;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiCallHelper {
    public static final String AUTH_TOKEN = new ApiTokenAuthentication().getAuthToken();
    public static String KEY = "8e665bf2ef41412285b164af82710525";
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> get(String pathParam) {
        return getHeader().get(pathParam).then().log().all().extract();
    }

    public static ExtractableResponse<?> post(String pathParam, Object body) {
        return getHeader().body(body).when().post(pathParam).then().log().all().extract();
    }

    public static ExtractableResponse<?> post(String pathParam, Object body, String id) {
        return getHeader().body(body).when().post(pathParam + id).then().log().all().extract();
    }

    public static ExtractableResponse<?> delete(String pathParam) {
        return getHeader().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> put(String pathParam, Object body) {
        return getHeader().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patch(String pathParam, Object body) {
        return getHeader().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patch(String pathParam, Object body, String id) {
        return getHeader().body(body).when().patch(pathParam + id).then().log().all().extract();
    }

    
    /**
     * Works as an alternative header managament unit.
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeader() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", KEY).log().all();
    }    
 
}