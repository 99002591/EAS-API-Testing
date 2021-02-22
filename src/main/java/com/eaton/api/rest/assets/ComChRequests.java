package com.eaton.api.rest.assets;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONObject;

import com.eaton.api.framework.APIs;
import com.eaton.api.rest.common.ApiCallHelper;

import io.restassured.response.ExtractableResponse;

public class ComChRequests {

    public static ExtractableResponse<?> createWithAssertion(JSONObject body) {
        String pathParam = APIs.CommChannel.CREATE_COMM_CHANNEL;
        ExtractableResponse<?> response = ApiCallHelper.post(pathParam, body.toString());
        assertThat(response.statusCode()).as("Create Failed:".concat(APIs.RESPONSE).concat(response.body().asPrettyString()).concat(APIs.REQUEST).concat(body.toString(5))).isEqualTo(201);
        return response;
    }
    
    public static ExtractableResponse<?> create(JSONObject body) {
        String pathParam = APIs.CommChannel.CREATE_COMM_CHANNEL;
        return ApiCallHelper.post(pathParam, body.toString());
    }
	
    public static ExtractableResponse<?> updateWithAssertion(JSONObject body, String id) {
        String pathParam = APIs.CommChannel.UPDATE_COMM_CHANNEL + id;
        ExtractableResponse<?> response = ApiCallHelper.patch(pathParam, body.toString());
        assertThat(response.statusCode()).as("Update Failed:".concat(APIs.RESPONSE).concat(response.body().asPrettyString()).concat(APIs.REQUEST).concat(body.toString(5))).isEqualTo(200);
        return response;
    }
    
    public static ExtractableResponse<?> update(JSONObject body, String id) {
        String pathParam = APIs.CommChannel.UPDATE_COMM_CHANNEL + id;
        return ApiCallHelper.patch(pathParam, body.toString());
    }
    
    public static ExtractableResponse<?> deleteWithAssertion(String id) {
        String pathParam = APIs.CommChannel.DELETE_COMM_CHANNEL + id;
        ExtractableResponse<?> response = ApiCallHelper.delete(pathParam);
        assertThat(response.statusCode()).as("Delete Failed: ID = ".concat(id).concat(APIs.RESPONSE).concat(response.body().asPrettyString())).isEqualTo(200);
        return response;
    }
    
    public static ExtractableResponse<?> delete(String id) {
        String pathParam = APIs.CommChannel.DELETE_COMM_CHANNEL + id;
        return ApiCallHelper.delete(pathParam);
    }
    
    public static ExtractableResponse<?> getWithAssertion(String id) {
        String pathParam = APIs.CommChannel.GET_COMM_CHANNEL + id;
        ExtractableResponse<?> response = ApiCallHelper.get(pathParam);
        assertThat(response.statusCode()).as("Get Failed: ID = ".concat(id).concat(APIs.RESPONSE).concat(response.body().asPrettyString())).isEqualTo(200);
        return response;
    }
    
    public static ExtractableResponse<?> get(String id) {
        String pathParam = APIs.CommChannel.GET_COMM_CHANNEL + id;
        return ApiCallHelper.get(pathParam);
    }
}
