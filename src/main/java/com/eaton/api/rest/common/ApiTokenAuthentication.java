package com.eaton.api.rest.common;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.eaton.api.framework.ValidUserLogin;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponse;

public class ApiTokenAuthentication {

	private static final long MINUTES_TO_REFRESH_TOKEN = 30;
	private String authToken = null;
	private static Cache<String, String> tokenCache = CacheBuilder.newBuilder()
			.expireAfterWrite(MINUTES_TO_REFRESH_TOKEN, TimeUnit.MINUTES).build();
	private static final String AUTH_TOKEN_KEY = "authTokenKey";

	public String getAuthToken() {
		if (tokenCache == null || tokenCache.getIfPresent(AUTH_TOKEN_KEY) == null) {
			synchronized (this) {
				if (tokenCache == null || tokenCache.getIfPresent(AUTH_TOKEN_KEY) == null) {
					authToken = generateToken();
				}
			}
		}
		return authToken;
	}

	// @SuppressWarnings("unchecked")
	private static String generateToken() {

		JSONObject loginRequest = new JSONObject();

		loginRequest.put("serviceAccountId", ValidUserLogin.getUserName());
		loginRequest.put("secret", ValidUserLogin.getPassword());
		ValidatableResponse authTokenValue = null;
		String authTokenValue_string = null;

		baseURI = "https://eas-all-apim-eus-dev.azure-api.net";
		authTokenValue = given().accept("application/json").contentType("application/json").header("Ocp-Apim-Subscription-Key", "8e665bf2ef41412285b164af82710525")
				.body(loginRequest.toString()).when().post("/serviceAccount/token").then();
		System.out.println("BODY DONE");
		authTokenValue_string = authTokenValue.extract().jsonPath().getString("Token");
		tokenCache.put(AUTH_TOKEN_KEY, authTokenValue_string);
		System.out.println("TOKEN DONE");
		return authTokenValue_string;
	}
}