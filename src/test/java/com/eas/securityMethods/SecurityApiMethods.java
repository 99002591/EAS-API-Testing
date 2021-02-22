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
	public static RequestSpecification rSpec;
	public String authTokenGenerator() {
		jsonReader jsonReaderObj = new jsonReader();
		specBuilder specBuilderObj = new specBuilder();
		JSONObject JsonObj = new JSONObject(jsonContent);
		try {
			jsonContent = jsonReaderObj.readJSONfile(credentialStore);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		rSpec = specBuilderObj.requestSpecs();
		// REPLACE THIS BY A POST FUNCTION //
		rawResponse = given().spec(rSpec).body(JsonObj).when().post(specBuilderObj.LOGIN).then();
		authToken = rawResponse.extract().jsonPath().getString("authToken");
		return authToken;
	}
	
	// **************************************************** //

}
