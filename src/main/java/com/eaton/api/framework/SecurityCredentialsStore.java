package com.eaton.api.framework;

public class SecurityCredentialsStore {

    public SecurityCredentialsStore() {
    }

    private static final String AUTOMATION_USER = "a10cfc64-1b4c-4583-aa0e-ba94720ce82c";
    private static final String AUTOMATION_PASS = "IMxm39~n5-Os8d9Af3PP8yC-RLAm_SdFvF";

    public static String getUserName() {
        return AUTOMATION_USER;
    }

    public static String getPassword() {
        return AUTOMATION_PASS;
    }

}
