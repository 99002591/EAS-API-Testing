package com.eaton.easdr.api.tests;

import static org.testng.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.eaton.easdr.api.assertionStatements.Assertion;
import com.eaton.easdr.api.builders.RequestBodyBuilder;
import com.eaton.easdr.api.framework.APIs;
import com.eaton.easdr.api.framework.SecurityAccountToken;
import com.eaton.easdr.api.rest.assets.ParameterizedApiRequests;
import com.eaton.easdr.api.testdata.DataProviderClass;

import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {

	public static ExtractableResponse<?> response;
	public static Assertion assertObj = new Assertion();

	@Test(description = "Successfully login to generate Authentication token")
	public static void api_P1_success() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.setSecret(SecurityAccountToken.getSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.Ok.getValue());
		assertEquals(response.statusLine(), assertObj.ALL_OK_LINE);
	}

	@Test(description = "Invalid Service Account ID", dataProvider = "InvalidSecurityAcctTokenData", dataProviderClass = DataProviderClass.class)
	public static void api_P1_invalidID(String serviceActID, String secret) {
		JSONObject request = new RequestBodyBuilder.Builder().setServiceAccountId(serviceActID).setSecret(secret).build();
		System.out.println(request.toString());
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.NotFound.getValue());
		assertEquals(response.statusLine(), assertObj.NOT_FOUND_LINE);
		assertEquals(response.jsonPath().getString("ErrorCode"), APIs.StatusCode.NotFound.getValue().toString());
		assertEquals(response.jsonPath().getString("Message"),assertObj.invalidAccount(request.getString("serviceAccountId")));
	}

	@Test(description = "Blank Service Account ID", dataProvider = "BlankSecurityAcctTokenData", dataProviderClass = DataProviderClass.class)
	public static void api_P1_blankID(String serviceActID, String secret) {
		JSONObject request = new RequestBodyBuilder.Builder().setServiceAccountId(serviceActID).setSecret(secret).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), assertObj.BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_BLANK_CLIENT);
		assertEquals(response.jsonPath().getString("ErrorCode"), APIs.StatusCode.BadRequest.getValue().toString());
		assertEquals(response.jsonPath().getString("'InvalidParameters'[0]"), "ClientId");
	}

	@Test(description = "Invalid Secret")
	public static void api_P1_InvalidSecret() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.setSecret(SecurityAccountToken.getInvalidSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.Unauthorized.getValue());
		assertEquals(response.statusLine(), assertObj.UNAUTHORIZED_LINE);
		assertEquals(response.jsonPath().getString("errorCode"), APIs.StatusCode.Unauthorized.getValue().toString());
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_INVALID_ID_SECRET_COMB);
	}

	@Test(description = "Blank Secret")
	public static void api_P1_blankSecret() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), assertObj.BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_BLANK_SECRET);
		assertEquals(response.jsonPath().getString("ErrorCode"), APIs.StatusCode.BadRequest.getValue().toString());
		assertEquals(response.jsonPath().getString("'InvalidParameters'[0]"), "ClientSecret");
	}

	@Test(description = "Invalid Service account ID format")
	public static void api_P1_invalidGUID() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getInvalidServiceAcctID())
				.build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), assertObj.BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_INVALID_UUID);
		assertEquals(response.jsonPath().getString("ErrorCode"), APIs.StatusCode.BadRequest.getValue().toString());
		assertEquals(response.jsonPath().getString("'InvalidParameters'[0]"), "ClientId");
		
	}
}