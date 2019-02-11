package in.reqres;

import org.testng.Assert;

import com.rest_APICaller.Configuration;
import com.rest_test.BaseTest;

public class ReqresBaseTest extends BaseTest {
	
	public static final String pageJsonPath = "$..page";
	public static final String idJsonPath	= "$..id";
	
	public static void verifyValue(String response,String jsonPath, Object value){
		
		String obtValue = Configuration.jsonValueExtractor(response, jsonPath);
		Assert.assertEquals(obtValue,value.toString());
		
	}

}
