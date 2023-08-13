package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
public class ParsingXmlResponse {
//Approach 1:
	@Test
	public void testXmlResponse1()
	{
		given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
	}
	
// Approach 2:
	@Test
	public void testXmlResponse2()
	{
		Response res= given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		Assert.assertEquals(res.getStatusCode(),200 );
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8" );
		
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "Developer");	
	}	
}
