package day7;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {
	
//	@Test(priority=1)
	public void testBasicAuth()
	{
		given()
			.auth().basic("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
			
			.then()
				 .statusCode(200)
				 .body("authenticated", equalTo(true))
				 .log().all();
	}
	
//	@Test(priority=2)
	public void testDigestAuth()
	{
		given()
			.auth().digest("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
			
			.then()
				 .statusCode(200)
				 .body("authenticated", equalTo(true))
				 .log().all();
	}
	
//	@Test(priority=3)
	public void testPreemptiveAuth()
	{
		given()
			.auth().preemptive().basic("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
			
			.then()
				 .statusCode(200)
				 .body("authenticated", equalTo(true))
				 .log().all();
	}
	
	@Test
	public void testBearerTokenAuth()
	{
		String token= "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";
		
		given()
			.header("Authorization", "Bearer "+token)
		
			.when()
				.get("https://api.github.com/user/repos")
			
			.then()
				 .statusCode(401)
				 .log().all();
	}
	
	@Test
	public void testOAuth1Authentication()
	{	
		given()
			.auth().oauth("ConsumerKey", "ConsumerSecret","AccessToken","TokenSecret")
		
			.when()
				.get("Url")
			
			.then()
				 .statusCode(200)
				 .log().all();
	}
	
	@Test
	public void testOAuth2Authentication()
	{	
		given()
			.auth().oauth2("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")
		
			.when()
				.get("https://api.github.com/user/repos")
			
			.then()
				 .statusCode(200)
				 .log().all();
	}
	
	@Test
	public void testApiKeyuthentication()
	{	
		given()
			.queryParam("ApiKey", "KeyValue")
		
			.when()
				.get("url")
			
			.then()
				 .statusCode(200)
				 .log().all();
	
//	Note: Here we can divide url into domain, path parameters and query parameters and we can pass path and query parameters in the given section.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
