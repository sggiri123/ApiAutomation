package day3;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.Map;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

@Test
public void testHeader()
{
	given()
	
		.when()
			.get("https://www.google.com/")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding","gzip")
			.header("Server", "gws");
			
}
@Test
public void getHeadersInfo()
{
	Response res=given()
	
		.when()
			.get("https://www.google.com/");
	
	String header= res.getHeader("Content-Type");
	System.out.println(header);
	
	Headers list =res.getHeaders();
	
	for(Header k:list) 
	{
		String value = list.getValue("Content-Type");
		System.out.println(k+"   "+ value);
		
	}
	
	
	
			
}
	
}
