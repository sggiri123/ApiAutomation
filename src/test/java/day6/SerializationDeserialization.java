package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.Pojo_PostRequest;

public class SerializationDeserialization {
	
//	@Test
	public void serialization() throws JsonProcessingException  
	{
//		Creating java object using pojo class
		
		Pojo_PostRequest pojoObj = new Pojo_PostRequest();
		pojoObj.setName("Shiva");
		pojoObj.setAddress("Shevga");
		pojoObj.setCompany("ZP");
		String [] arr= {"Student","Nojob"};
		pojoObj.setRoles(arr);
		
//     Converting pojo class to json object
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData= objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoObj);
		System.out.println(jsonData);
	}
	@Test
	public void deSerialization() throws JsonMappingException, JsonProcessingException
	{
// Creating json object with the string data, simply copy output of first method in double quotation
		
		String jsonData = "{\r\n"
				+ "  \"name\" : \"Shiva\",\r\n"
				+ "  \"address\" : \"Shevga\",\r\n"
				+ "  \"company\" : \"ZP\",\r\n"
				+ "  \"roles\" : [ \"Student\", \"Nojob\" ]\r\n"
				+ "}";

// Converting jsonObject into pojo object
		
		ObjectMapper objMapper = new ObjectMapper();
		Pojo_PostRequest pojoObj =	objMapper.readValue(jsonData, Pojo_PostRequest.class);
		System.out.println("Name: "+pojoObj.getName());
		System.out.println("Adress: "+pojoObj.getAddress());
		System.out.println("Company: "+pojoObj.getCompany());
		System.out.println("Course 1: "+pojoObj.getRoles()[0]);
		System.out.println("Course 2: "+pojoObj.getRoles()[1]);
	}
	
	
	

}
