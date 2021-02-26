package com.eaton.easdr.api.testdata;

import com.eaton.easdr.api.framework.SecurityAccountToken;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "InvalidSecurityAcctTokenData")
	public Object[][] invalidSecurityAcctTokenData() {

		return new Object[][] {

				{ "a10cfc64-1b4c-4583-aa0e-ba94720ce81E", "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdGvG" }, // Invalid Secret
				{ "a10cfc64-1b4c-4583-aa0e-ba94720ce81E", "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF" }, // Valid Secret

		};
	}

	@DataProvider(name = "BlankSecurityAcctTokenData")
	public Object[][] blankSecurityAcctTokenData() {

		return new Object[][] {

				{ "", "" }, // Blank Secret
				{ "", "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF" }, // Valid Secret

		};
	}

}