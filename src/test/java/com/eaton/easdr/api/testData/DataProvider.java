package com.eaton.easdr.api.testData;

import com.eaton.easdr.api.framework.SecurityAccountToken;

public class DataProvider {
	public static SecurityAccountToken secObj = new SecurityAccountToken();

	/*
	 * Fetches service account ID
	 */
	@org.testng.annotations.DataProvider(name="ServiceAccountIDFetcher")
    public Object[] getServiceAccountIdData(){
		return new Object[] {
			secObj.getServiceAcctID()
		};
	}

	/*
	 * Fetches the secret
	 */
	@org.testng.annotations.DataProvider(name="SecretFetcher")
    public Object[] getSecretData(){
		return new Object[] {
				secObj.getSecret()
			};
	}
}
