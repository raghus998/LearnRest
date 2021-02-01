package demorequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest1Test 
{
	@Test
	public void createRequest()
	{
		// Specify the Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Create the Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Specify the request payload in JSON format
		JSONObject requestParameter = new JSONObject();

		requestParameter.put("FirstName", "Demo111");
		requestParameter.put("LastName", "Demo111");
		requestParameter.put("UserName", "rs111");
		requestParameter.put("Password", "RS111231");
		requestParameter.put("Email", "Rs11@gmai1l.com");

		// Specify the payload type as JSON type
		httprequest.headers("Content-Type", "application/json");

		// add the JSON payload to requestBody
		httprequest.body(requestParameter.toJSONString());

		// post the request
		Response response = httprequest.request(Method.POST, "/register");

		// get the response body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		// get the status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Validate the response Body
		String succesCode = response.jsonPath().get("SuccessCode").toString();
		String message = response.jsonPath().get("Message").toString();
		System.out.println(succesCode+"      "+message);
		Assert.assertEquals(succesCode, "OPERATION_SUCCESS");
	}

}
