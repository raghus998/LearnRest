package demorequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestTest1 
{
	@Test
	public void createRequest()
	{
		
		//Specify the Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Create the Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify the request payload in JSON format
		JSONObject requestParameter = new JSONObject();
		
		requestParameter.put("FirstName", "Demo111122");
		requestParameter.put("LastName", "Demo1111");
		requestParameter.put("UserName", "rs1111");
		requestParameter.put("Password", "RS1111231");
		requestParameter.put("Email", "Rs111@gmai1l.com");
		
		//Specify the Payload type as  JSON type
		httpRequest.header("Content-Type", "application/json");
		
		//add the JSON payload to  request body
		httpRequest.body(requestParameter.toJSONString());
		
		//Post a request
		Response response = httpRequest.request(Method.POST, "/register");
		
		//get hte response body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//get the ststus Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Validate response body
		String successCode = response.jsonPath().get("SuccessCode").toString();
		System.out.println(successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
