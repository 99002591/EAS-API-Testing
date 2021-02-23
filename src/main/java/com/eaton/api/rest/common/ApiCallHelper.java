package com.eaton.api.rest.common;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.eaton.api.builders.assets.commchannel.ApiPayloadBuilder;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiCallHelper {
    public static final String AUTH_TOKEN = new ApiTokenAuthentication().getAuthToken();	
    public static final String INVALID_AUTH_TOKEN = "SomeRANdom12345AuthenticationToken";
    public static final String BLANK_AUTH_TOKEN = "";
    public static final String SUB_KEY = "8e665bf2ef41412285b164af82710525";
    public static final String INVALID_SUB_KEY = "7e665bf2ef41412285b164af82767890";
    public static final String BLANK_SUB_KEY = "";
    
    public static String AuthTokenStore;
    public static String genericJSONObj;
    public static ApiPayloadBuilder PayloadObj = new ApiPayloadBuilder();
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
    public static ExtractableResponse<?> postForLogin(String path){
    	genericJSONObj = PayloadObj.credetials();
    	System.out.println(genericJSONObj);
    	AuthTokenStore = AUTH_TOKEN;
    	return getHeaderForLogin().body(genericJSONObj).when().post(path).then().log().all().extract();
    }
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> post(String pathParam, Object body) {
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
    public static ExtractableResponse<?> getIA(String pathParam) {
        return getHeaderIA().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postIA(String pathParam, Object body) {
        return getHeaderIA().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postIA(String pathParam, Object body, String id) {
        return getHeaderIA().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteIA(String pathParam) {
        return getHeaderIA().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putIA(String pathParam, Object body) {
        return getHeaderIA().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchIA(String pathParam, Object body) {
        return getHeaderIA().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchIA(String pathParam, Object body, String id) {
        return getHeaderIA().body(body).when().patch(pathParam + id).then().log().all().extract();
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
    public static ExtractableResponse<?> getBA(String pathParam) {
        return getHeaderBA().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBA(String pathParam, Object body) {
        return getHeaderBA().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBA(String pathParam, Object body, String id) {
        return getHeaderBA().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteBA(String pathParam) {
        return getHeaderBA().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putBA(String pathParam, Object body) {
        return getHeaderBA().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchBA(String pathParam, Object body) {
        return getHeaderBA().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchBA(String pathParam, Object body, String id) {
        return getHeaderBA().body(body).when().patch(pathParam + id).then().log().all().extract();
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
    public static ExtractableResponse<?> getNA(String pathParam) {
        return getHeaderNA().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNA(String pathParam, Object body) {
        return getHeaderNA().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNA(String pathParam, Object body, String id) {
        return getHeaderNA().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteNA(String pathParam) {
        return getHeaderNA().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putNA(String pathParam, Object body) {
        return getHeaderNA().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchNA(String pathParam, Object body) {
        return getHeaderNA().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchNA(String pathParam, Object body, String id) {
        return getHeaderNA().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 5.******************************************************************************* //
    // *********************  API CALLS WITH INCORRECT SUBS KEY  *********************** //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getIS(String pathParam) {
        return getHeaderIS().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postIS(String pathParam, Object body) {
        return getHeaderIS().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postIS(String pathParam, Object body, String id) {
        return getHeaderIS().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteIS(String pathParam) {
        return getHeaderIS().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putIS(String pathParam, Object body) {
        return getHeaderIS().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchIS(String pathParam, Object body) {
        return getHeaderIS().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchIS(String pathParam, Object body, String id) {
        return getHeaderIS().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 6.******************************************************************************* //
    // **********************   API CALLS WITH BLANK SUBS KEY   ************************ //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getBS(String pathParam) {
        return getHeaderBS().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBS(String pathParam, Object body) {
        return getHeaderBS().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postBS(String pathParam, Object body, String id) {
        return getHeaderBS().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteBS(String pathParam) {
        return getHeaderBS().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putBS(String pathParam, Object body) {
        return getHeaderBS().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchBS(String pathParam, Object body) {
        return getHeaderBS().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchBS(String pathParam, Object body, String id) {
        return getHeaderBS().body(body).when().patch(pathParam + id).then().log().all().extract();
    }        
    // --------------------------------------------------------------------------------- //
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
    
    
    // 7.******************************************************************************* //
    // **********************    API CALLS WITH NO SUBSC KEY    ************************ //
    // ********************************************************************************* //
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP GET method for specified URI
     * and request parameter.
     * 
     */
    public static ExtractableResponse<?> getNS(String pathParam) {
        return getHeaderNS().get(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNS(String pathParam, Object body) {
        return getHeaderNS().body(body).when().post(pathParam).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP POST method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> postNS(String pathParam, Object body, String id) {
        return getHeaderNS().body(body).when().post(pathParam + id).then().log().all().extract();
    }
    
    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP DELETE method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> deleteNS(String pathParam) {
        return getHeaderNS().delete(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PUT method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> putNS(String pathParam, Object body) {
        return getHeaderNS().body(body).put(pathParam).then().log().all().extract();
    }

    /**
     * Returns <code>ExtractableResponse</code> by invoking corresponding HTTP PATCH method for specified URI
     * and request parameter.
     */
    public static ExtractableResponse<?> patchNS(String pathParam, Object body) {
        return getHeaderNS().body(body).when().patch(pathParam).then().log().all().extract();
    }
    
    public static ExtractableResponse<?> patchNS(String pathParam, Object body, String id) {
        return getHeaderNS().body(body).when().patch(pathParam + id).then().log().all().extract();
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
    private static RequestSpecification getHeaderIA() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + INVALID_AUTH_TOKEN, "Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }   
    
    /**
     * Header management with Blank Authentication token
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderBA() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + BLANK_AUTH_TOKEN, "Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }   
    
    /**
     * Header management with No Authentication
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderNA() {
        return given().accept("application/json").contentType("application/json").header("Ocp-Apim-Subscription-Key", SUB_KEY).log().all();
    }    
 
    /**
     * Header management with Incorrect Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderIS() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", INVALID_SUB_KEY).log().all();
    }   
    
    /**
     * Header management with Blank Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderBS() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN, "Ocp-Apim-Subscription-Key", BLANK_SUB_KEY).log().all();
    }  
    
    /**
     * Header management with No Subscription Key
     * @return The entire header sequence for a REST call
     */
    private static RequestSpecification getHeaderNS() {
        return given().accept("application/json").contentType("application/json").header("Authorization", "Bearer " + AUTH_TOKEN).log().all();
    }   
}