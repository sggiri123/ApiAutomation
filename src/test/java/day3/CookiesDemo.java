package day3;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.Map;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {

//@Test

public void testCookies() 
{
	given()
	
	.when()
		.get("https://www.google.com/")
		
	.then()
		.cookie("AEC", "Ad49MVHmN6BP_m8nMFoqrcC0Wiq9XeLzFkM79lWKYZfBDVC6gG3h5Cd5fA")
		.log().all();
}

//@Test
public void getCookiesInfo()
{
	Response res =given()
	
	.when()
		.get("https://www.google.com/");
	

//	String cookieValue=res.getCookie("AEC");
//	System.out.println("Value of Cookie is: "+cookieValue);
	
	Map<String, String> CookiesInfo =res.getCookies();
	System.out.println(CookiesInfo );     //Printing all Cookies and values
	System.out.println(CookiesInfo.keySet());    // Printing only Cookies
	 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
