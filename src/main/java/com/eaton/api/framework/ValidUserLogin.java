package com.eaton.api.framework;

public class ValidUserLogin {

    private ValidUserLogin() {
    }

    private static final String AUTOMATION_USER = "automation";
    private static final String AUTOMATION_PASS = "automation";

    public static String getUserName() {

        return AUTOMATION_USER;
    }

    public static String getPassword() {

        return AUTOMATION_PASS;
    }

}
