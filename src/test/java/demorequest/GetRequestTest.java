package demorequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestTest 
{
	@Test
	public void getWeatherRequest()
	{
		//Specify the base URL
		RestAssured.baseURI = "https://reqres.in/";
		
		//Create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create the response object
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		
		//get response body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//get  status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//get statusLine
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		
		
		
	}

}
