package demorequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Autherization 
{
	@Test
	public void testA() 
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		
		RestAssured.authentication = auth;

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
