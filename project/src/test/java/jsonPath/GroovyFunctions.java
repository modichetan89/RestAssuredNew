package jsonPath;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GroovyFunctions {
	@Test
	public void findAndFindAllDemo() {
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\jsonPath\\People.json";
		File jsonArrayFile = new File(filePath);
		
		JsonPath jsonPath = new JsonPath(jsonArrayFile);
		
		String firstName = jsonPath.getString("data[0].first_name");
		System.out.println(firstName);
		//return firstName for 0 index array of data

		List<Object> allFirstNames = jsonPath.getList("data.first_name") ;
		System.out.println(allFirstNames);
		//return firstName from all indexes of array data.
		
		List<String> allFemales = jsonPath.getList("data.findAll{it.gender == 'Female'}.first_name");
		System.out.println(allFemales);
		//Find all firstName node from json which have siblings node gender with value as female. here "it" will iterate values from beginning to end
		//If it is at root node, not inside data, then we can use directly findAll instead of data.findAll
		//("findAll{it.gender == 'Female'}.first_name")
		
		String emailWithAnd = jsonPath.getString("data.find{it.first_name == 'Lindsay' & it.last_name == 'Ferguson'}.email");
		System.out.println(emailWithAnd);
		//Find email id of person which have given firstname and lastname.
		//If it is at root node, not inside data, then we can use directly findAll instead of data.find
		
		List<String> emailWithOr = jsonPath.getList("data.findAll{it.first_name == 'Lindsay' | it.last_name == 'Funke'}.email");
		System.out.println(emailWithOr);
		
		System.out.println(jsonPath.getList("data.findAll{it.id>=9}.first_name"));
		
		System.out.println(jsonPath.getInt("data.size()"));
		
		System.out.println(jsonPath.getList("data.first_name.findAll{it.length() > 5}"));
		
		List<Integer> sizes = jsonPath.getList("data.first_name.collect{it.length()}");
		System.out.println(sizes);
		
		//https://www.baeldung.com/rest-assured-groovy
	
	}
	
}
