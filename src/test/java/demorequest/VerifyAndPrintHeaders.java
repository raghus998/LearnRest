package demorequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyAndPrintHeaders
{
	@Test
	public void verifyHeaders()
	{
		
		//Specify the Base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Create the Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create Response Object
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.86"
				+ "70522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print the response BODy
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Verify the Headers
		String contentType = response.header("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println(contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		//To print all Headers
		Headers AllHeaders = response.getHeaders();
		System.out.println(AllHeaders);
		
		System.out.println("...........................................");
		for (Header header : AllHeaders)
		{
			System.out.println(header.getName()+"        "+header.getValue());
			
		}
	/*	String status = response.jsonPath().get("status").toString();
		System.out.println(status);*/
		
		
		
		
		
		
		
		
		
	}

}
