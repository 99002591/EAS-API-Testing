package com.eaton.easdr.api.framework;

public class SecurityAccountToken {

    public SecurityAccountToken() {
    }

    private static final String AUTOMATION_ACCT_ID = "a10cfc64-1b4c-4583-aa0e-ba94720ce82c";
    private static final String AUTOMATION_SECRET = "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF";

    public static String getServiceAcctID() {
        return AUTOMATION_ACCT_ID;
    }

    public static String getSecret() {
        return AUTOMATION_SECRET;
    }

}
