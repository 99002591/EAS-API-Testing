package com.eaton.easdr.api.builders;

import org.json.JSONObject;

public class RequestBodyBuilder {

	/*
	 * JSON KEYS
	 */
	public static final String SERVICEACCOUNT_ID = "serviceAccountId";
	public static final String SECRET = "secret";
	public static final String DEVICE_ID = "deviceId";
	public static final String SITE_ID = "";
	
	public static class Builder {

		protected String secret;
		protected String serviceAccount_ID;
		protected String device_ID;
		protected String site_ID;
		/**
		 * Default constructor
		 */
		public Builder() {
		}

		// **************************************************** //
		// *********** VALUE SETTERS FOR KEYS ************ //
		// **************************************************** //

		public Builder setServiceAccountId(String serviceAccountID) {
			this.serviceAccount_ID = serviceAccountID;
			return this;
		}

		public Builder setSecret(String secret) {
			this.secret = secret;
			return this;
		}

		public Builder setDeviceId(String deviceid) {
			this.device_ID = deviceid;
			return this;
		}

		// **************************************************** //
		// *********** JSON OBJECT BUILDER ************ //
		// **************************************************** //

		public JSONObject build() {
			JSONObject setter = new JSONObject();
			setter.put(SERVICEACCOUNT_ID, this.serviceAccount_ID);
			setter.put(SECRET, this.secret);
			setter.put(DEVICE_ID, this.device_ID);
			return setter;
		}
	}
}
