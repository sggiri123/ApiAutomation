package day6;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	@Test
    public void validateSchema()
	{
		given()
		
		.when()
			.get("http://localhost:3000/Book")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"));
	
    }

}
