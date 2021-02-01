package data.driven.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployeeData 
{
	@Test
	public void getdata()
	{

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/employees");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}

}
