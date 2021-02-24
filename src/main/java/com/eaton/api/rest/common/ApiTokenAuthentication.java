package com.eaton.api.rest.common;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.eaton.api.framework.APIs;
import com.eaton.api.framework.ConfigFileReader;
import com.eaton.api.framework.SecurityAccountToken;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

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

	@SuppressWarnings("static-access")
	private static String generateToken() {

		JSONObject loginRequest = new JSONObject();
		loginRequest.put("serviceAccountId", SecurityAccountToken.getUserName());
		loginRequest.put("secret", SecurityAccountToken.getPassword());
		ValidatableResponse authTokenValue = null;
		String authTokenValue_string = null;
		APIs APIObj = new APIs();
		try {
			ConfigFileReader configFileReader = new ConfigFileReader();
			baseURI = configFileReader.getApplicationUrl();
			authTokenValue = given().accept("application/json").contentType("application/json")
					.header("Ocp-Apim-Subscription-Key", "8e665bf2ef41412285b164af82710525")
					.body(loginRequest.toString()).when().post(APIObj.API_1_SECURITY).then();
		} catch (Exception e) {
			// left empty on purpose
		}
		authTokenValue_string = authTokenValue.extract().jsonPath().getString("Token");
		tokenCache.put(AUTH_TOKEN_KEY, authTokenValue_string);
		return authTokenValue_string;
	}
}