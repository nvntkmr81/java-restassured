package com.insta;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rest_APICaller.Configuration;
import com.rest_APICaller.InstaAPICaller;


public class TestClass extends BaseTest {


	@Test
	public void sampleTest() {
		String response = InstaAPICaller.doGet();
		String status = Configuration.jsonValueExtractor(response, "$..code");

		Assert.assertEquals(status, "400");
	}
	@Test
	public void sampleTest2() {

		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("count", 10);
		String response = InstaAPICaller.doGet(parameters);
		String status = Configuration.jsonValueExtractor(response, "$..code");
		Assert.assertEquals(status, "400");
	}
	
	@Test
	public void sampleTest3() {

		String response = InstaAPICaller.doGet();
		String errorType = Configuration.jsonValueExtractor(response, "$..error_type");

		Assert.assertEquals(errorType, "OAuthParameterException");
	}
	@Test
	public void sampleTest4() {

		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("count", 10);
		String response = InstaAPICaller.doGet();
		String status = Configuration.jsonValueExtractor(response, "$..error_type");
		Assert.assertEquals(status, "OAuthParameterException");
	}

}