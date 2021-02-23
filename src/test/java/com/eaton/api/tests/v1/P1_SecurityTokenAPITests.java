package com.eaton.api.tests.v1;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.eaton.api.rest.assets.ParameterizedApiRequests;
import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {
	public static ParameterizedApiRequests ParamApiObj = new ParameterizedApiRequests();
	public static ExtractableResponse<?> raw_response;
	public static String API_1_ENDPOINT = "/serviceAccount/token";
	
	// ***** //
	public static final int ALL_OK_CODE = 200;
	public static final String ALL_OK_LINE = "HTTP/1.1 200 OK";
	// ***** //
	
	@Test(description = "Succesffully login to generate Authentication token")
	public static void successfullyLogin() {
		raw_response = ParamApiObj.postToLogin(API_1_ENDPOINT);
		System.out.println(raw_response.body().asPrettyString());
		assertEquals(raw_response.statusCode(), ALL_OK_CODE);
		assertEquals(raw_response.statusLine(), ALL_OK_LINE);
	}
}
