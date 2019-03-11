package com.reqres;

import org.testng.Assert;

import com.insta.BaseTest;
import com.rest_APICaller.Configuration;

public class ReqresBaseTest extends BaseTest {
	
	public static final String pageJsonPath = "$..page";
	public static final String idJsonPath	= "$..id";
	public static final String nameJsonPath = "$..name";
	public static final String jobJsonPath = "$..job";
	
	
	public static void verifyValue(String response,String jsonPath, Object value){
		
		String obtValue = Configuration.jsonValueExtractor(response, jsonPath);
		Assert.assertEquals(obtValue,value.toString());
		
	}

}
