package com.eas.specBuilder;

import io.restassured.specification.RequestSpecification;

public class specBuilder {
	// ******************************************************************** //
	// ****************** ENDPOINTS AND CONSTANTS ************************* //
	// ******************************************************************** //
	public static String KEY = "8e665bf2ef41412285b164af82710525";
	
	// ******************************************************************** //
	
	public static RequestSpecification reqSpec;
	
	public static RequestSpecification requestSpecs(String header1, String value1, String header2, String value2) {
		reqSpec.headers("Ocp-Apim-Subscription-Key", KEY, "Content-Type", "application/json", header1, value1, header2, value2);
		return reqSpec;
	}
	
	public static RequestSpecification requestSpecs(String header1, String value1) {
		reqSpec.headers("Ocp-Apim-Subscription-Key", KEY, "Content-Type", "application/json", header1, value1);
		return reqSpec;
	}
	
	public static RequestSpecification requestSpecs() {
		reqSpec.headers("Ocp-Apim-Subscription-Key", KEY, "Content-Type", "application/json");
		return reqSpec;
	}
}
