package com.eaton.api.framework;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;

public class ApiTestSetup {
	private static String baseUrl;
	private static Faker faker;
	private static Logger logger;
	private static final String EXCEPTION_MSG = "Exception :";

	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
		try {
			logger = setupLogger();
			initialSetup();
		} catch (Exception ex) {
			logger.fine(EXCEPTION_MSG + ex);
		}
	}

	public static void initialSetup() {
		try {
			ConfigFileReader configFileReader = new ConfigFileReader();

			setBaseUrl(configFileReader.getApplicationUrl());

			setFaker(new Faker());
		} catch (Exception ex) {
			logger.fine(EXCEPTION_MSG + ex);
		}
	}

	public static Logger setupLogger() {
		Logger newLogger = Logger.getLogger("selenium.logger");
		newLogger.setLevel(Level.ALL);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		handler.setLevel(Level.ALL);
		newLogger.addHandler(handler);

		return newLogger;
	}

	public static Faker getFaker() {
		return ApiTestSetup.faker;
	}

	private static void setFaker(Faker faker) {
		ApiTestSetup.faker = faker;
	}

	private static void setBaseUrl(String baseUrl) {
		ApiTestSetup.baseUrl = baseUrl;
	}

	public static String getBaseUrl() {
		return ApiTestSetup.baseUrl;
	}

}
