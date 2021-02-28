package com.eaton.easdr.api.rest.assets;
import org.json.JSONObject;

import com.eaton.easdr.api.rest.common.ApiCallHelper;

import io.restassured.response.ExtractableResponse;
import java.lang.reflect.*;

public class ParameterizedApiRequests {
	
	// ***************************************************** //
	// *************     POST REQUESTS      **************** //
	// ***************************************************** //
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON obj
	 * @param id : incase the API has an ID pararmeter in URI
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> postwithPathParamAndBody(String path, String body, String id){
		return ApiCallHelper.post(path, body, id);
	}
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON obj
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> postWithPathAndBody(String path, String body){
		return ApiCallHelper.post(path, body);
	}
	
	/**
	 * @param path : the endpoint
	 * @param body : null (no body in this post request)
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> postToLogin(String path, String body){
		return ApiCallHelper.postForLogin(path, body);
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
	
	
	// ***************************************************** //
	// *************     GET REQUESTS      **************** //
	// ***************************************************** //
	
	/**
	 * @param path : the endpoint
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> getFromPath(String path){
		return ApiCallHelper.get(path);
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
	
	
	// ***************************************************** //
	// *************      PUT REQUESTS      **************** //
	// ***************************************************** //
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON object
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> putWithPathAndBody(String path, JSONObject body){
		return ApiCallHelper.put(path, body);
	}
	
	/**
	 * @param path : the endpoint
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> putWithPath(String path){
		return ApiCallHelper.put(path, null);
	}

	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
	
	// ***************************************************** //
	// *************    PATCH REQUESTS      **************** //
	// ***************************************************** //
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON object
	 * @param id : incase the API has an ID pararmeter in URI
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> patchwithPathParamAndBody(String path, JSONObject body, String id){
		return ApiCallHelper.patch(path, body, id);
		}
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON Object
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> patchWithPathAndBody(String path, JSONObject body){
		return ApiCallHelper.patch(path, body);
	}
	
	/**
	 * @param path : the endpoint
	 * @param body : null (no body in this post request)
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> patchWithPathandNoBody(String path){
		return ApiCallHelper.patch(path, null);
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
	
	// ***************************************************** //
	// ************     DELETE REQUESTS      *************** //
	// ***************************************************** //
	
	/**
	 * @param path : the endpoint
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> deleteAtPath(String path){
		return ApiCallHelper.delete(path);
	//Figure out how to call deleteBA, deleteIA etc with variables//
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
	
	
	// ***************************************************** //
	// ************     INVALID REQUESTS      ************** //
	// ***************************************************** //
	
	// ************************************************************************ //
	// **********************   INDEX FOR PARAM: selector  *********************//
	
	// getInvalidAuthentication : GET request with Invalid authentication key   //
	// getBlankAuthentication : GET request with Blank authentication key       //
	// getInvalidSubscription : GET request with Invalid subscription key       //
	// getBlankSubscription : GET request with Blank subscription key           //
	// getNoSubscription : GET request with No subscription key                 //
	 
	// postInvalidAuthentication : POST request with Invalid authentication key //
	// postBlankAuthentication : POST request with Blank authentication key     //
	// postInvalidSubscription : POST request with Invalid subscription key     //
	// postBlankSubscription : POST request with Blank subscription key         //
	// postNoSubscription : POST request with No subscription key               //
	
	// deleteInvalidAuthentication : DELETE request with Invalid authentication key //
	// deleteBlankAuthentication : DELETE request with Blank authentication key     //
	// deleteInvalidSubscription : DELETE request with Invalid subscription key     //
	// deleteBlankSubscription : DELETE request with Blank subscription key         //
	// deleteNoSubscription : DELETE request with No subscription key               //
	
	// putInvalidAuthentication : PUT request with Invalid authentication key   //
	// putBlankAuthentication : PUT request with Blank authentication key       //
	// putInvalidSubscription : PUT request with Invalid subscription key       //
	// putBlankSubscription : PUT request with Blank subscription key           //
	// putNoSubscription : PUT request with No subscription key                 //
	
	// patchInvalidAuthentication : PATCH request with Invalid authentication key   //
	// patchBlankAuthentication : PATCH request with Blank authentication key       //
	// patchInvalidSubscription : PATCH request with Invalid subscription key       //
	// patchBlankSubscription : PATCH request with Blank subscription key           //
	// patchNoSubscription : PATCH request with No subscription key                 //
	
	// **************************************************************************** //
	
	public static ApiCallHelper ApiHelpObj = new ApiCallHelper();
	public static ExtractableResponse<?> genericInvalidResponse;
	
	/**
	 * @param path : the endpoint
	 * @param selector : Choose from the types of header management methods
	 * @return genericInvalidResponse : Extractable raw API response
	 */
	public static ExtractableResponse<?> apiHelper(String selector, String path) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends ApiCallHelper> reflectObj = ApiHelpObj.getClass();
		try {
			Method methodCall = reflectObj.getDeclaredMethod(selector, String.class);
			genericInvalidResponse = (ExtractableResponse<?>) methodCall.invoke(reflectObj, path);	
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return genericInvalidResponse;
	}
	
	/**
	 * @param path : the endpoint
	 * @param selector : Choose from the types of header management methods
	 * @param body : the API body as a JSON object
	 * @return genericInvalidResponse : Extractable raw API response
	 */
	public static ExtractableResponse<?> apiHelper(String selector, String path, String body) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends ApiCallHelper> reflectObj = ApiHelpObj.getClass();
		try {
			Method methodCall = reflectObj.getDeclaredMethod(selector, String.class, String.class);
			genericInvalidResponse = (ExtractableResponse<?>) methodCall.invoke(reflectObj, path, body);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return genericInvalidResponse;
	}
	
	/**
	 * @param path : the endpoint
	 * @param selector : Choose from the types of header management methods
	 * @param body : the API body as a JSON object
	 * @param id : any id to be passed as path parameters
	 * @return genericInvalidResponse : Extractable raw API response
	 */
	public static ExtractableResponse<?> apiHelper(String selector, String path, String body, String id) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends ApiCallHelper> reflectObj = ApiHelpObj.getClass();
		try {
			Method methodCall = reflectObj.getDeclaredMethod(selector, String.class, String.class, String.class, String.class);
			genericInvalidResponse = (ExtractableResponse<?>) methodCall.invoke(reflectObj, path, body, id);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return genericInvalidResponse;
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
}
