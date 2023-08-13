package day5;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;
public class FileUploadDownload {
// We need to have file-upload-RestAPI.jar file at some location in the system.
// Run this jar file using command java -jar file path on command prompt. We will get api for passing in request.     
	@Test
	public void uploadSingleFile()
	{
		File myFile = new File("C:\\Users\\shridhar.giri\\Test1.txt");
		
		given()
			.multiPart("file", myFile)
			.contentType("multipart/form-data")
			
		.when()
			.post("http://localhost:8080/uploadFile")
			
		.then()
			.statusCode(200)
			.body("fileName", equalTo("Test1.txt"))
			.log().all();
	}
	
	@Test
	public void uploadMultipleFile()
	{
		File myFile1 = new File("C:\\Users\\shridhar.giri\\Test1.txt");
		File myFile2 = new File("C:\\Users\\shridhar.giri\\Test2.txt");
		
//		We can use File[] files  = {myFile1, myFile2 }
		
		given()
			.multiPart("files", myFile1)
			.multiPart("files", myFile2)
//          .multiPart("files", files)
			.contentType("multipart/form-data")
			
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
			
		.then()
			
			.body("[0].fileName", equalTo("Test1.txt"))
			.body("[1].fileName", equalTo("Test2.txt"))
			.log().all(); 
	}
 
	@Test
	public void downloadFile()
	{
		given()
			
		.when()
			.get("http://localhost:8080/downloadFile/Test1.txt")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
