package com.eaton.api.framework;

public class APIs {

	public static final String REQUEST = "\nRequest:\n";
	public static final String RESPONSE = "\nResponse:\n";
	public static final String EQUALS = " = ";

	public static final String API_1_SECURITY = "/serviceAccount/token";
	public static final String API_2_SITE = "";
	public static final String API_3_SITE = "";
	public static final String API_4_SITE = "";

	public enum StatusCode {
		Ok(200), Created(201), BadRequest(400), Unauthorized(401), Forbidden(402), NotFound(404), Unprocessable(422);

		private Integer code;

		StatusCode(Integer code) {
			this.code = code;
		}

		public Integer getValue() {
			return code;
		}
	}
}
