package com.eaton.easdr.api.framework;


import org.testng.annotations.BeforeSuite;


public class ApiTestSetup {
	private static String baseUrl;

	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
		try {
			initialSetup();
		} catch (Exception ex) {
		}
	}

	public static void initialSetup() {
		try {
			ConfigFileReader configFileReader = new ConfigFileReader();

			setBaseUrl(configFileReader.getApplicationUrl());

		} catch (Exception ex) {
		}
	}

	private static void setBaseUrl(String baseUrl) {
		ApiTestSetup.baseUrl = baseUrl;
	}

	public static String getBaseUrl() {
		return ApiTestSetup.baseUrl;
	}

}
