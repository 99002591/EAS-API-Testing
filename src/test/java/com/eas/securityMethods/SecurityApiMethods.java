package com.eas.securityMethods;

import com.eas.specBuilder.specBuilder;
import com.eas.utilities.jsonReader;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import static io.restassured.RestAssured.*;

public class SecurityApiMethods {
	
	// **************************************************** //
	// *************** Globa use variables *************** //
	// **************************************************** //
	public static ValidatableResponse rawResponse;
	public static String credentialStore = "src/test/resources/com/eas/payload/credentials.json";
	public static String jsonContent;
	// **************************************************** //
	
	
	// **************************************************** //
	// ********** Authentication Token Generator ********** //
	// **************************************************** //
	public static String authToken;
	
	public String authTokenGenerator() {
		jsonReader jsonReaderObj = new jsonReader();
		try {
			jsonContent = jsonReaderObj.readJSONfile(credentialStore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject JsonObj = new JSONObject(jsonContent);		
		specBuilder specBuilderObj = new specBuilder();
		
		rawResponse = (ValidatableResponse) given().spec(specBuilderObj.reqSpec).
				body(JsonObj).when().post("ENDPOINT").
				then().extract().response();
		
		return authToken;
	}
	
	// **************************************************** //

}
