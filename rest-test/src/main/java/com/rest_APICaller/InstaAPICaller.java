package com.rest_APICaller;

import java.util.Map;
import io.restassured.RestAssured;
import utility.Log;

public class InstaAPICaller extends APICaller{
	
	private static final String instaEndPoint = "https://api.instagram.com/v1/users/search";

	public static String doGet() {
		Log.info("***************Request***************");
		Log.info("GET: "+instaEndPoint);
		String response = RestAssured.given().log().uri().when().contentType("application/json;charset=utf-8")
	    		.get(instaEndPoint).then().extract().body().asString();
		Log.info("***************Response*************");
		Log.info(response);
		return response;
	}
	
	public static String doGet(Map<String,Object> map) {
		Log.info("***************Request***************");
		Log.info("GET: "+instaEndPoint);
		String response = RestAssured.given().log().uri().when().contentType("application/json;charset=utf-8").params(map)
	    		.get(instaEndPoint).then().extract().body().asString();
		Log.info("***************Response*************");
		Log.info(response);
		return response;
	}
}
