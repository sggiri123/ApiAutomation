package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	@Test
	public void testQueryAndPathParameters()
	{
		given()
			.pathParam("myPath", "users")  //path parameters key and value
			.queryParam("page",2)          //query parameters key and value
			.queryParam("id", 5)           //query parameters key and value
		.when()
			.get("https://reqres.in/api/{myPath}")    //No need to write query parameters here it will automatically take from the given section.
		.then()
			.statusCode(200)
			.log().all();
			
	}

}
