package in.reqres;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.rest_APICaller.ReqresAPICaller;

import utility.Log;

public class GetSingleUserTest extends ReqresBaseTest{
	
	private static final String singleUserInterface = "/api/users/";
	
	@Test
	public static void get_user_with_userID_test1(){
		Log.info("Getr User with User ID =  2");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", 2);
		String response =  ReqresAPICaller.doGet(param,singleUserInterface);
		verifyValue(response, idJsonPath, 2);
	}

}
