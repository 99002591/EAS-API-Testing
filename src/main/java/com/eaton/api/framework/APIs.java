package com.eaton.api.framework;

public class APIs {

	public static final String REQUEST = "\nRequest:\n";
	public static final String RESPONSE = "\nResponse:\n";
	public static final String EQUALS = " = ";

	public static final class CommChannel {
		public static final String CREATE_COMM_CHANNEL = "/api/devices/commChannels";
		public static final String GET_COMM_CHANNEL = "/api/devices/commChannels/";
		public static final String GET_ALL_COMM_CHANNELS = "/api/devices/commChannels";
		public static final String UPDATE_COMM_CHANNEL = "/api/devices/commChannels/";
		public static final String DELETE_COMM_CHANNEL = "/api/devices/commChannels/";
	}
	
	public static final class ApiEndpoints {
		public static final String API_1_SECURITY = "";
		public static final String API_2_SITE = "";
		public static final String API_3_SITE = "";
		public static final String API_4_SITE = "";
	}
	
	public enum StatusCode {
		Ok(200),
		Created(201),
		BadRequest(400),
		Unauthorized(401),
		Forbidden(402),
		NotFound(404),
		Unprocessable(422);
		
		private Integer code;
		
		StatusCode(Integer code) {
			this.code = code;
		}
		
		public Integer getValue() { return code; }
	}
}
