package com.eaton.api.tests.v1;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.eaton.api.builders.assets.commchannel.RequestBodyBuilder;
import com.eaton.api.framework.APIs;
import com.eaton.api.rest.assets.ParameterizedApiRequests;
import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {
	public static ParameterizedApiRequests ParamApiObj = new ParameterizedApiRequests();
	public static APIs APIObj = new APIs();
	public static ExtractableResponse<?> raw_response;

	// ***** //
	public static final int ALL_OK_CODE = 200;
	public static final String ALL_OK_LINE = "HTTP/1.1 200 OK";
	// ***** //

//	@Test(description = "Succesfully login to generate Authentication token with JSON OBJECT BUILDER")
//	public static void successfullyLogin_JO() {
//		raw_response = ParamApiObj.postToLogin(APIObj.API_1_SECURITY);
//		System.out.println(raw_response.body().asPrettyString());
//		assertEquals(raw_response.statusCode(), ALL_OK_CODE);
//		assertEquals(raw_response.statusLine(), ALL_OK_LINE);
//	}

	@Test(description = "Successfully login to generate Authentication token with BUILDER PATTERN")
	public static void successfullyLogin_BP() {
		JSONObject setBody = new RequestBodyBuilder.PayloadBuilder().user("a10cfc64-1b4c-4583-aa0e-ba94720ce82c")
				.password("IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF").build();
		raw_response = ParamApiObj.postToLogin(APIObj.API_1_SECURITY, setBody.toString());
		assertEquals(raw_response.statusCode(), ALL_OK_CODE);
		assertEquals(raw_response.statusLine(), ALL_OK_LINE);
	}
}
