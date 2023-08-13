package day8;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser {

	@Test 
	public void test_CreateUser(ITestContext context)
	{
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String token = "fc46e7079d7f0a64f52d5ca37f4c5ed1a77d68c96ad457330e03a95ddfbcd3c9";
		
		int id=given()
			.headers("Authorization","Bearer "+token)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("The generated ID: "+id);
		
//		context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
		
		
	}
	
	
	
	
	
}
