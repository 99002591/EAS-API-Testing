package com.eaton.easdr.api.tests;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.eaton.easdr.api.builders.RequestBodyBuilder;
import com.eaton.easdr.api.framework.APIs;
import com.eaton.easdr.api.framework.SecurityAccountToken;
import com.eaton.easdr.api.rest.assets.ParameterizedApiRequests;

import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {
	public static ParameterizedApiRequests ParamApiObj = new ParameterizedApiRequests();
	public static APIs APIObj = new APIs();
	public static ExtractableResponse<?> response;
	public static SecurityAccountToken secObj = new SecurityAccountToken();

	// ***** //
	public static final int ALL_OK_CODE = 200;
	public static final String ALL_OK_LINE = "HTTP/1.1 200 OK";
	// ***** //

	@SuppressWarnings("static-access")
	@Test(description = "Successfully login to generate Authentication token")
	public static void api_P1_success() {
		JSONObject request = new RequestBodyBuilder.Builder().setServiceAccountId(secObj.getServiceAcctID())
				.setSecret(secObj.getSecret()).build();
		response = ParamApiObj.postToLogin(APIObj.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.Ok.getValue());
//		assertEquals(response.statusLine(), ALL_OK_LINE);
	}
}
