package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	public void testGenerateDummyData()
	{
		Faker faker = new Faker();
		
		String fullName= faker.name().fullName();
		String firstName= faker.name().firstName();
		
		String userName = faker.name().username();
		String password = faker.internet().password();
		
		String mobNo = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		String color = faker.color().name();
		String animal = faker.animal().name();
		
		System.out.println("fullName: "+fullName);
		System.out.println("firstName: "+firstName);
		System.out.println("userName: "+userName);
		System.out.println("password: "+password);
		System.out.println("mobNo: "+mobNo);
		System.out.println("color: "+color);
		System.out.println("animal: "+animal);
	}

}
