package com.eaton.api.builders.assets.commchannel;

import org.json.JSONObject;

public class RequestBodyBuilder {
	/*
	 * JSON KEYS
	 */
	public static final String USER = "serviceAccountId";
	public static final String PASSWORD = "secret";
	public static final String DEVICE_ID = "deviceId";
//	public static final String 

	public static class PayloadBuilder {
		protected String secret;
		protected String user;
		protected String device_ID;

		/**
		 * Default constructor
		 */
		public PayloadBuilder() {
		}
		
		// **************************************************** //
		// ***********   VALUE SETTERS FOR KEYS    ************ //
		// **************************************************** //
		public PayloadBuilder user(String user) {
			this.user = user;
			return this;
		}
		public PayloadBuilder password(String secret) {
			this.secret = secret;
			return this;
		}
		public PayloadBuilder deviceid(String deviceid) {
			this.device_ID = deviceid;
			return this;
		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++ //
		// ---------------------------------------------------- //
		
		
		// **************************************************** //
		// ***********     JSON OBJECT BUILDER     ************ //
		// **************************************************** //
		public JSONObject build() {
			JSONObject setter = new JSONObject();
			setter.put(USER, this.user);
			setter.put(PASSWORD, this.secret);
			setter.put(DEVICE_ID, this.device_ID);
			return setter;
		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++ //
		// ---------------------------------------------------- //
	}
}
