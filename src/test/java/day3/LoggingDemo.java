package day3;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class LoggingDemo {
	
	@Test
	public void testLogs()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.log().body()     //Printing only response excluding headers, cookies and status codes
			.log().cookies()  //Printing only cookies from the response
			.log().headers(); //Printing only headers from the response	
		
	}

}
