package data.driven.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddNewEmployee 
{
	@Test
	public void addNewEmpolyee()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we created data whihc we can send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "RS");
		requestParams.put("salary", "22222");
		requestParams.put("age", "24");
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//Send post request
		Response response = httpRequest.request(Method.POST,"/create");
		
		//Get response body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertTrue(responseBody.contains("RS"));
		Assert.assertTrue(responseBody.contains("22222"));
		Assert.assertTrue(responseBody.contains("24"));
		Assert.assertTrue(responseBody.contains("success"));
		
		//get status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
