package demorequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyJSONResponseBody 
{
	@Test
	public void test()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"Delhi");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertTrue(responseBody.contains("Delhi"));
	}

}
