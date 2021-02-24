package com.eaton.easdr.api.rest.common;

import static io.restassured.RestAssured.given;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiCallHelper {
    public static final String AUTH_TOKEN = new ApiTokenAuthentication().getAuthToken();	
    public static final String INVALID_AUTH_TOKEN = "SomeRANdom12345AuthenticationToken";
    public static final String BLANK_AUTH_TOKEN = "";
    public static final String SUB_KEY = "8e665bf2ef41412285b164af82710525";
    public static final String INVALID_SUB_KEY = "7e665bf2ef41412285b164af82767890";
    public static final String BLANK_SUB_KEY = "";
    
    // 1.******************************************************************************* //
    // ******************* API CALLS WITH CORRECT HEADER MANAGEMENT ******************** //
    // ********************************************************************************* //
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter
     */
    public static ExtractableResponse<?> get(String path) {
        return getHeader().get(path).then().log().all().extract();
    }
    /**
     * This POST method is only used for valid login
     * as it contains no Authentication token header
     */
    public static ExtractableResponse<?> postForLogin(String path, String body){
    	return getHeaderForLogin().body(body).when().post(path).then().log().all().extract();
    }
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> post(String pathParam, String body) {
        return getHeader().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> post(String pathParam, Object body, String id) {
        return getHeader().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
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
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 2.******************************************************************************* //
    // ******************** API CALLS WITH INCORRECT AUTH TOKEN ************************ //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getInvalidAuthentication(String pathParam) {
        return getHeaderInvalidAuthentication().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postInvalidAuthentication(String pathParam, Object body) {
        return getHeaderInvalidAuthentication().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postInvalidAuthentication(String pathParam, Object body, String id) {
        return getHeaderInvalidAuthentication().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteInvalidAuthentication(String pathParam) {
        return getHeaderInvalidAuthentication().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putInvalidAuthentication(String pathParam, Object body) {
        return getHeaderInvalidAuthentication().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchInvalidAuthentication(String pathParam, Object body) {
        return getHeaderInvalidAuthentication().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchInvalidAuthentication(String pathParam, Object body, String id) {
        return getHeaderInvalidAuthentication().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 3.******************************************************************************* //
    // *********************   API CALLS WITH BLANK AUTH TOKEN   *********************** //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getBlankAuthentication(String pathParam) {
        return getHeaderBlankAuthentication().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBlankAuthentication(String pathParam, Object body) {
        return getHeaderBlankAuthentication().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBlankAuthentication(String pathParam, Object body, String id) {
        return getHeaderBlankAuthentication().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteBlankAuthentication(String pathParam) {
        return getHeaderBlankAuthentication().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putBlankAuthentication(String pathParam, Object body) {
        return getHeaderBlankAuthentication().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchBlankAuthentication(String pathParam, Object body) {
        return getHeaderBlankAuthentication().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchBlankAuthentication(String pathParam, Object body, String id) {
        return getHeaderBlankAuthentication().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 4.******************************************************************************* //
    // *********************   API CALLS WITH NO AUTHENTICATION  *********************** //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getNoAuthentication(String pathParam) {
        return getHeaderNoAuthentication().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNoAuthentication(String pathParam, Object body) {
        return getHeaderNoAuthentication().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNoAuthentication(String pathParam, Object body, String id) {
        return getHeaderNoAuthentication().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteNoAuthentication(String pathParam) {
        return getHeaderNoAuthentication().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putNoAuthentication(String pathParam, Object body) {
        return getHeaderNoAuthentication().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchNoAuthentication(String pathParam, Object body) {
        return getHeaderNoAuthentication().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchNoAuthentication(String pathParam, Object body, String id) {
        return getHeaderNoAuthentication().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 5.******************************************************************************* //
    // ****************  API CALLS WITH INCORRECT SUBSCRIPTION KEY  ******************** //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getInvalidSubscription(String pathParam) {
        return getHeaderInvalidSubscription().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postInvalidSubscription(String pathParam, Object body) {
        return getHeaderInvalidSubscription().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postInvalidSubscription(String pathParam, Object body, String id) {
        return getHeaderInvalidSubscription().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteInvalidSubscription(String pathParam) {
        return getHeaderInvalidSubscription().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putInvalidSubscription(String pathParam, Object body) {
        return getHeaderInvalidSubscription().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchInvalidSubscription(String pathParam, Object body) {
        return getHeaderInvalidSubscription().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchInvalidSubscription(String pathParam, Object body, String id) {
        return getHeaderInvalidSubscription().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 6.******************************************************************************* //
    // *****************   API CALLS WITH BLANK SUBSCRIPTION KEY   ********************* //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getBlankSubscription(String pathParam) {
        return getHeaderBlankSubscription().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBlankSubscription(String pathParam, Object body) {
        return getHeaderBlankSubscription().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBlankSubscription(String pathParam, Object body, String id) {
        return getHeaderBlankSubscription().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteBlankSubscription(String pathParam) {
        return getHeaderBlankSubscription().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putBlankSubscription(String pathParam, Object body) {
        return getHeaderBlankSubscription().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchBlankSubscription(String pathParam, Object body) {
        return getHeaderBlankSubscription().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchBlankSubscription(String pathParam, Object body, String id) {
        return getHeaderBlankSubscription().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 7.******************************************************************************* //
    // **********************    API CALLS WITH NO SUBSCRIPTION KEY    ***************** //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getNoSubscription(String pathParam) {
        return getHeaderNoSubscription().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNoSubscription(String pathParam, Object body) {
        return getHeaderNoSubscription().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNoSubscription(String pathParam, Object body, String id) {
        return getHeaderNoSubscription().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteNoSubscription(String pathParam) {
        return getHeaderNoSubscription().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putNoSubscription(String pathParam, Object body) {
        return getHeaderNoSubscription().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchNoSubscription(String pathParam, Object body) {
        return getHeaderNoSubscription().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchNoSubscription(String pathParam, Object body, String id) {
        return getHeaderNoSubscription().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // ***************************************************************** //
    // ********************** HEADER MANAGEMENT ************************ //
    // ***************************************************************** //
    /**
     * Works as header management for the initial login only
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderForLogin() {
        return given().accept("application/json").contentType("application/json").header("Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }  
    
    /**
     * Works as a <correct> alternative header managament unit.
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeader() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }    
 
    /**
     * Header management with Incorrect Authentication token
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderInvalidAuthentication() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + INVALID_AUTH_TOKEN, "Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }   
    
    /**
     * Header management with Blank Authentication token
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderBlankAuthentication() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + BLANK_AUTH_TOKEN, "Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }   
    
    /**
     * Header management with No Authentication
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderNoAuthentication() {
        return given().accept("application/json").contentType("application/json").header("Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }    
 
    /**
     * Header management with Incorrect Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderInvalidSubscription() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", INVALID_SUB_KEY).log().all();
    }   
    
    /**
     * Header management with Blank Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderBlankSubscription() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", BLANK_SUB_KEY).log().all();
    }  
    
    /**
     * Header management with No Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderNoSubscription() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN).log().all();
    }   
}