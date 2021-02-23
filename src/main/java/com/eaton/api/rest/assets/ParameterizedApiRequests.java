package com.eaton.api.rest.assets;
import org.json.JSONObject;
import com.eaton.api.rest.common.ApiCallHelper;
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
	public static ExtractableResponse<?> postwithPathParamAndBody(String path, JSONObject body, String id){
		return ApiCallHelper.post(path, body, id);
	}
	
	/**
	 * @param path : the endpoint
	 * @param body : the payload for the API as JSON obj
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> postWithPathAndBody(String path, JSONObject body){
		return ApiCallHelper.post(path, body);
	}
	
	/**
	 * @param path : the endpoint
	 * @param body : null (no body in this post request)
	 * @return Extractable Api Response
	 */
	public static ExtractableResponse<?> postWithPathandNoBody(String path){
		return ApiCallHelper.post(path, null);
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
	
	// ***************************************************** //
	// ************   INDEX FOR PARAM: selector  ************//
	
	// getIA : GET request with Invalid authentication key   //
	// getBA : GET request with Blank authentication key     //
	// getNA : GET request with No authentication            //
	// getIS : GET request with Invalid subscription key     //
	// getBS : GET request with Blank subscription key       //
	// getNS : GET request with No subscription key          //
	 
	// postIA : POST request with Invalid authentication key //
	// postBA : POST request with Blank authentication key   //
	// postNA : POST request with No authentication          //
	// postIS : POST request with Invalid subscription key   //
	// postBS : POST request with Blank subscription key     //
	// postNS : POST request with No subscription key        //
	
	// deleteIA : DELETE request with Invalid authentication key //
	// deleteBA : DELETE request with Blank authentication key   //
	// deleteNA : DELETE request with No authentication          //
	// deleteIS : DELETE request with Invalid subscription key   //
	// deleteBS : DELETE request with Blank subscription key     //
	// deleteNS : DELETE request with No subscription key        //
	
	// putIA : PUT request with Invalid authentication key //
	// putBA : PUT request with Blank authentication key   //
	// putNA : PUT request with No authentication          //
	// putIS : PUT request with Invalid subscription key   //
	// putBS : PUT request with Blank subscription key     //
	// putNS : PUT request with No subscription key        //
	
	// patchIA : PATCH request with Invalid authentication key //
	// patchBA : PATCH request with Blank authentication key   //
	// patchNA : PATCH request with No authentication          //
	// patchIS : PATCH request with Invalid subscription key   //
	// patchBS : PATCH request with Blank subscription key     //
	// patchNS : PATCH request with No subscription key        //
	
	// *************************************************** //
	
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
			Method methodCall = reflectObj.getDeclaredMethod(selector, String.class);
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
			Method methodCall = reflectObj.getDeclaredMethod(selector, String.class);
			genericInvalidResponse = (ExtractableResponse<?>) methodCall.invoke(reflectObj, path, body, id);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return genericInvalidResponse;
	}
	// ------------------------------------------------------ //
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //
}
