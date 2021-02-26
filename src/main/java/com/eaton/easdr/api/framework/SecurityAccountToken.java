package com.eaton.easdr.api.framework;

public class SecurityAccountToken {

    public SecurityAccountToken() {
    }

    private static final String SERVICE_ACCT_ID = "a10cfc64-1b4c-4583-aa0e-ba94720ce82c";
    private static final String SECRET = "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF";
	private static final String INVALID_SERVICE_ACCT_ID = "a10cfewe-1b4c-4583-aa0e-ba947";
	private static final String INAVLID_SECRET = "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdGhG";
	private static final String BLANK_SECRET = "";
	
	public static String getServiceAcctID() {
		return SERVICE_ACCT_ID;
	}

	public static String getSecret() {
		return SECRET;
	}
	
	public static String getInvalidSecret() {
		return INAVLID_SECRET;
	}

	public static String getBlankSecret() {
		return BLANK_SECRET;
	}
	
	public static String getInvalidServiceAcctID() {
		return INVALID_SERVICE_ACCT_ID;
	}

}
