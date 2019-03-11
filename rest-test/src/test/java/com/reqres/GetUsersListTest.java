package com.reqres;

import org.testng.annotations.Test;

import com.rest_APICaller.ReqresAPICaller;

import utility.Log;

public class GetUsersListTest extends ReqresBaseTest{
	private static final String getUsersListInterface = "/api/users";
	
	@Test (groups = { "reqrestest", "gettest" })
	public static void getUsersTest1(){
		Log.info("Test 1 for users list without parameters");
		
		String response = ReqresAPICaller.doGet(getUsersListInterface);
		verifyValue(response,pageJsonPath,1);
	}

}
