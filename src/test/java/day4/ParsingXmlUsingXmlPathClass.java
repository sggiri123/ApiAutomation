package day4;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.List;
public class ParsingXmlUsingXmlPathClass {
	
@Test
	public void testXmlResponse()
	{
		Response res= given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		XmlPath obj = new XmlPath(res.asString());
		List<String> travelersInfo = obj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
   // Verify noOfTravelers
		
		Assert.assertEquals(travelersInfo.size(), 10);
	
   // Verify traveler name is present in the cml response
		
		List<String> travelersName = obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status = false;
		for (String k:travelersName)
		{
			if (k.equals("Developer")) {
				System.out.println("Name is available");
				status = true;
				break;
			}
			
		}
		
		Assert.assertTrue(status);
		
		 
}


}
