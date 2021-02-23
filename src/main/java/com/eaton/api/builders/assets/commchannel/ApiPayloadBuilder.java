package com.eaton.api.builders.assets.commchannel;
import org.json.JSONObject;
import com.eaton.api.framework.ValidUserLogin;

public class ApiPayloadBuilder {
	
	public static String credetials() {
		JSONObject loginRequest = new JSONObject();
		loginRequest.put("serviceAccountId", ValidUserLogin.getUserName());
		loginRequest.put("secret", ValidUserLogin.getPassword());
		return loginRequest.toString();
	}
}
