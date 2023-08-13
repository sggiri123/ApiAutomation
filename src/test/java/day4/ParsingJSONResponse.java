package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import org.json.*;

public class ParsingJSONResponse {
//Approach 1 validation using .then()
	
	@Test
	public void testJsonResponseApproch1()
	{
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/Book")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("[3].title", equalTo("Heropanti"));
		
	}
	
//Approach 2 Capturing response in some variable and validating data using assertions.

	@Test
	public void testJsonResponseApproach2()
	{
		Response res =given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/Book");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().get("[3].title").toString(), "Heropanti");	
	}
	
//Approach3 Capturing all books from JSONObject--JSOnArray---JSONObjects---title field
	
	@Test
	public void testJsonResponseApproach3()
	{
		Response res =given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/Book");
		
		
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("Book").length(); i++)
		{
			String bookName=jo.getJSONArray("Book").getJSONObject(i).get("title").toString();
			System.out.println(bookName);
		}
	}
	

}
