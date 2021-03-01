package com.eaton.easdr.api.tests;

import static org.testng.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.eaton.easdr.api.assertionStatements.assertionStatements;
import com.eaton.easdr.api.builders.RequestBodyBuilder;
import com.eaton.easdr.api.framework.APIs;
import com.eaton.easdr.api.framework.SecurityAccountToken;
import com.eaton.easdr.api.rest.assets.ParameterizedApiRequests;
import com.eaton.easdr.api.testdata.DataProviderClass;

import io.restassured.response.ExtractableResponse;

public class P1_SecurityTokenAPITests {

	public static ExtractableResponse<?> response;
	public static assertionStatements assertObj = new assertionStatements();

	// ***** //
	public static final String ALL_OK_LINE = "HTTP/1.1 200 OK";
	public static final String NOT_FOUND_LINE = "HTTP/1.1 404 Not Found";
	public static final String BAD_REQUEST_LINE = "HTTP/1.1 400 Bad Request";
	public static final String UNAUTHORIZED_LINE = "HTTP/1.1 401 Unauthorized";
	// ***** //

	@Test(description = "Successfully login to generate Authentication token")
	public static void api_P1_success() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.setSecret(SecurityAccountToken.getSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.Ok.getValue());
		assertEquals(response.statusLine(), ALL_OK_LINE);
	}

	@Test(description = "Invalid Service Account ID", dataProvider = "InvalidSecurityAcctTokenData", dataProviderClass = DataProviderClass.class)
	public static void api_P1_invalidID(String serviceActID, String secret) {
		JSONObject request = new RequestBodyBuilder.Builder().setServiceAccountId(serviceActID).setSecret(secret)
				.build();
		System.out.println(request.toString());
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.NotFound.getValue());
		assertEquals(response.statusLine(), NOT_FOUND_LINE);
		assertEquals(response.jsonPath().getString("Message"),
				assertObj.invalidAccount(request.getString("serviceAccountId")));
	}

	@Test(description = "Blank Service Account ID", dataProvider = "BlankSecurityAcctTokenData", dataProviderClass = DataProviderClass.class)
	public static void api_P1_blankID(String serviceActID, String secret) {
		JSONObject request = new RequestBodyBuilder.Builder().setServiceAccountId(serviceActID).setSecret(secret)
				.build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_BLANK_CLIENT);
		assertThat(response.jsonPath().getList("InvalidParameters").contains("ClientId"));
	}

	@Test(description = "Invalid Secret")
	public static void api_P1_InvalidSecret() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.setSecret(SecurityAccountToken.getInvalidSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.Unauthorized.getValue());
		assertEquals(response.statusLine(), UNAUTHORIZED_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_INVALID_ID_SECRET_COMB);
	}

	@Test(description = "Blank Secret")
	public static void api_P1_blankSecret() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getServiceAcctID())
				.setSecret(SecurityAccountToken.getBlankSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_BLANK_SECRET);
		assertThat(response.jsonPath().getList("InvalidParameters").contains("ClientSecret"));
	}

	@Test(description = "Invalid Service account ID format")
	public static void api_P1_invalidGUID() {
		JSONObject request = new RequestBodyBuilder.Builder()
				.setServiceAccountId(SecurityAccountToken.getInvalidServiceAcctID())
				.setSecret(SecurityAccountToken.getBlankSecret()).build();
		response = ParameterizedApiRequests.postToLogin(APIs.API_P1_SECURITY, request.toString());
		assertThat(response.statusCode()).isEqualTo(APIs.StatusCode.BadRequest.getValue());
		assertEquals(response.statusLine(), BAD_REQUEST_LINE);
		assertEquals(response.jsonPath().getString("Message"), assertObj.P1_INVALID_UUID);
		assertThat(response.jsonPath().getList("InvalidParameters").contains("ClientId"));
	}
}