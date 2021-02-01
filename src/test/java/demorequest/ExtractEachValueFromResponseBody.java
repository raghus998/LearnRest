package demorequest;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractEachValueFromResponseBody 
{
	
	@Test
	public void testA()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"Delhi");
		
		//To get the response Body
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//To get the each node of response Body
		//JsonPath jsonNodes = response.jsonPath();
		JsonPath jsonNodes = new JsonPath(responseBody);
		Object city = jsonNodes.get("City");
		System.out.println(city);
		System.out.println(jsonNodes.get("Temperature"));
		System.out.println(jsonNodes.get("Humidity"));
		
		
		
		
		
		
	}
	
	

}
