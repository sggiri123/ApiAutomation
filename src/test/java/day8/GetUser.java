package day8;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	public void test_GetUser(ITestContext context)
	{
//		int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		String token = "fc46e7079d7f0a64f52d5ca37f4c5ed1a77d68c96ad457330e03a95ddfbcd3c9";
		given()
			.headers("Authorization", "Bearer "+token)
			.pathParam("id", id)
			
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
