package com.eaton.easdr.api.framework;

public class APIs {

	public static final String API_P1_SECURITY = "serviceAccount/token";
	public static final String API_P2_SITE = "";
	public static final String API_P3_SITE = "";
	public static final String API_P4_SITE = "";

	public enum StatusCode {
		Ok(200), BadRequest(400), Unauthorized(401), Forbidden(402), NotFound(404);

		private Integer code;

		StatusCode(Integer code) {
			this.code = code;
		}

		public Integer getValue() {
			return code;
		}
	}
}
