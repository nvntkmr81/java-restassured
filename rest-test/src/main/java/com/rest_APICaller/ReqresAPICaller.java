package com.rest_APICaller;

import java.util.Map;

import io.restassured.RestAssured;
import utility.Log;

public class ReqresAPICaller extends APICaller {
	
	private static final String reqresEndpoint = "https://reqres.in";
	
	public static String doGet(String apiInterface) {
		Log.info("***************Request***************");
		Log.info("GET: "+reqresEndpoint+apiInterface);
		String response = RestAssured.given().log().uri().when().contentType("application/json;charset=utf-8")
	    		.get(reqresEndpoint+apiInterface).then().extract().body().asString();
		Log.info("***************Response*************");
		Log.info(response);
		return response;
	}
	
	public static String doGet(Map<String,Object> map, String apiInterface) {
		Log.info("***************Request***************");
		Log.info("GET: "+reqresEndpoint+apiInterface);
		String response = RestAssured.given().log().uri().when().contentType("application/json;charset=utf-8").params(map)
	    		.get(reqresEndpoint+apiInterface).then().extract().body().asString();
		Log.info("***************Response*************");
		Log.info(response);
		return response;
	}

}
