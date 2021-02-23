package com.eaton.api.builders.assets.commchannel;
import org.json.JSONObject;
import com.eaton.api.framework.SecurityCredentialsStore;

public class ApiPayloadBuilder {
	
	public static String credetials() {
		JSONObject loginRequest = new JSONObject();
		loginRequest.put("serviceAccountId", SecurityCredentialsStore.getUserName());
		loginRequest.put("secret", SecurityCredentialsStore.getPassword());
		return loginRequest.toString();
	}
}
