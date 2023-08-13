package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test 
	public void test_UpdateUser(ITestContext context)
	{
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String token = "fc46e7079d7f0a64f52d5ca37f4c5ed1a77d68c96ad457330e03a95ddfbcd3c9";
		
//		int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
		
	}


}
