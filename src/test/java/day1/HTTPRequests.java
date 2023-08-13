package day1;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class HTTPRequests {
	int id;
	@Test (priority=1)
	public void getUser() 
	{
		given()  
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	@Test (priority=2)
	public void createuser() 
	{
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "Shridhar");
		data.put("job", "Senior Test Engineer");
		
		id=given()
			.contentType("application/json")
			.body(data)

		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test (priority=3, dependsOnMethods=("createuser"))
	public void updateUserDetails()
	{
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "Saikat");
		data.put("job", "Test Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test (priority=4)
	public void deleteUser()
	{
		given()
		
	    .when()
			.delete("https://reqres.in/api/users/"+id)
	    .then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	

}
