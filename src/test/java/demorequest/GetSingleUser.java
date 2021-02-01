package demorequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleUser 
{
	@Test
	public void testA()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		 Response response = httprequest.request(Method.GET, "/api/users/2");
		 
		 String responseBody = response.getBody().asString();
		 int statuscode = response.getStatusCode();
		 System.out.println(statuscode);
		 System.out.println(responseBody);
		 
		 
		 JsonPath JSONEVE = response.jsonPath();
		 Object data = JSONEVE.get("ad");
		 System.out.println(data);
		
		
		
	}

}
