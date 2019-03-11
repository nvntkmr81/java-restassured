package com.rest_APICaller;

import java.io.IOException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.Log;

public class ReqresAPICaller extends APICaller {

	private static final String reqresEndpoint = "https://reqres.in";
	private static final String createUserJson = "createUserJson";

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

	public static String[] doPost(Map<String,Object> parms, String apiInterface) throws IOException{
		String reqBody = Configuration.loadJson(createUserJson);
		reqBody = Configuration.jsonCreator(reqBody, parms);
		Log.info("***************Request***************");
		Log.info("GET: "+reqresEndpoint+apiInterface);
		
		Response resp = (Response) RestAssured.given().log().all().when().contentType("application/json;charset=utf-8").body(reqBody)
		.post(reqresEndpoint+apiInterface).then().extract();
		
		String response[] = {resp.body().asString(), ""+resp.statusCode()};
	
		Log.info("***************Response*************");
		Log.info(response[0]);
		return response;

	}

}
