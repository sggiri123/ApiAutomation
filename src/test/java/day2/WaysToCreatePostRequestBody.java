package day2;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import org.json.*;
import java.io.*;
public class WaysToCreatePostRequestBody {
	
@Test
public void usingHashmap() 
{
	HashMap<String, Object> data = new HashMap<String, Object>();
	data.put("name", "Umesh");
	data.put("address", "Pune");
	data.put("company","Ivy" );
	
	String[] arr = {"Tester","Developer"};
	data.put("roles", arr);
	
	given()
		.contentType("application/json")
		.body(data)
	.when()
		.post("http://localhost:3000/Employees")
	.then()
		.statusCode(201)
		.body("name", equalTo("Umesh"))
		.body("address", equalTo("Pune"))
		.body("roles[0]", equalTo("Tester"))
		.body("roles[1]", equalTo("Developer"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
}

@Test
public void usingOrgJson() 
{
	JSONObject data= new JSONObject();
	data.put("name", "Saikat");
	data.put("address", "Hyderabad");
	data.put("company","Ivy" );
	
	String[] arr = {"Manager","DevOps"};
	data.put("roles", arr);
	
	given()
		.contentType("application/json")
		.body(data.toString())
	.when()
		.post("http://localhost:3000/Employees")
	.then()
		.statusCode(201)
		.body("name", equalTo("Saikat"))
		.body("address", equalTo("Hyderabad"))
		.body("roles[0]", equalTo("Manager"))
		.body("roles[1]", equalTo("DevOps"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
}
@Test
public void usingPojo() 
{
	Pojo_PostRequest data = new Pojo_PostRequest();
	data.setName("Shiva");
	data.setAddress("Shevga");
	data.setCompany("ZP");
	
	String [] arr= {"Student","Nojob"};
	
	data.setRoles(arr);
	
	
	given()
		.contentType("application/json")
		.body(data)
	.when()
		.post("http://localhost:3000/Employees")
	.then()
		.statusCode(201)
		.body("name", equalTo("Shiva"))
		.body("address", equalTo("Shevga"))
		.body("roles[0]", equalTo("Student"))
		.body("roles[1]", equalTo("Nojob"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
}
@Test
public void usingJsonFile() throws FileNotFoundException 
{
	File f = new File(".\\body.json");
	FileReader fr = new FileReader(f);
	JSONTokener jt = new JSONTokener(fr);
	JSONObject data= new JSONObject(jt);
	
	
	given()
		.contentType("application/json")
		.body(data.toString())
	.when()
		.post("http://localhost:3000/Employees")
	.then()
		.statusCode(201)
		.body("name", equalTo("Shridhar"))
		.body("address", equalTo("Pune"))
		.body("roles[0]", equalTo("Tester"))
		.body("roles[1]", equalTo("Developer"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
}

}
