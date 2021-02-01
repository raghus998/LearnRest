package demorequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyResponseBody 
{
	@Test
	public void verifyResponseBody()
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		 String body = response.jsonPath().get().toString();
		System.out.println(body);
		
		//Verify response Body city node
		 String city = response.jsonPath().get("City").toString();
		System.out.println(city);
		Assert.assertEquals(city, "Hyderabad");
		
		
		
		
		
		
		
		
		
		
		
	}

}
