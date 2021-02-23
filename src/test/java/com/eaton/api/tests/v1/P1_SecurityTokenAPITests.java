package com.eaton.api.tests.v1;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.eaton.api.framework.APIs;
import com.eaton.api.rest.assets.ParameterizedApiRequests;
import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {
	public static ParameterizedApiRequests ParamApiObj = new ParameterizedApiRequests();
	public static APIs APIObj = new APIs();
	public static ExtractableResponse<?> raw_response;
	
	// ***** //
//	public static final int ALL_OK_CODE = 200;
	public static final String ALL_OK_LINE = "HTTP/1.1 200 OK";
	// ***** //
	
	@Test(description = "Succesffully login to generate Authentication token")
	public static void successfullyLogin() {
		raw_response = ParamApiObj.postToLogin(APIObj.API_1_SECURITY);
		System.out.println(raw_response.body().asPrettyString());
		assertEquals(raw_response.statusCode(), APIs.StatusCode.Ok);
		assertEquals(raw_response.statusLine(), ALL_OK_LINE);
	}
}
