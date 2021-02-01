package data.driven.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddNewMultipleEmployee 
{
	@Test(dataProvider = "empData")
	public void addNewMultipleEmpolyee(String eName,String eSal,String eAge)
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we created data whihc we can send along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", eName);
		requestParams.put("salary", eSal);
		requestParams.put("age", eAge);
		
	
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//Send post request
		Response response = httpRequest.request(Method.POST,"/create");
		
		//Get response body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertTrue(responseBody.contains(eName));
		Assert.assertTrue(responseBody.contains(eSal));
		Assert.assertTrue(responseBody.contains(eAge));
		Assert.assertTrue(responseBody.contains("success"));
		
		//get status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@DataProvider(name = "empData")
	public String[][] getData()
	{
		String[] [] empData = {{"RS1","369","22"},{"RS2","999","21"},{"RS3","333","20"}};
		return (empData);
	}
	
	
	
	
	
	
	
	
	
}
