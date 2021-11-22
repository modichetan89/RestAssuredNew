package dynamicPayloadJackson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateJsonWithoutPojo {
	public static void main(String args[]) throws StreamReadException, DatabindException, IOException{
		
		ObjectMapper objMapper = new ObjectMapper();
		Map<String, Object> address = objMapper.readValue(
				new File(System.getProperty("user.dir")
						+"\\src\\test\\resources\\jsonPayloads\\address.json"), 
						new TypeReference<Map<String, Object>>() {});
		/*
		
		TypeReference is an abstract class jackson core. 
		Here we created anonymous class of TypeReference
		Anonymous classes enable you to make your code more concise. 
		They enable you to declare and instantiate a class at the same time. 
		They are like local classes except that they do not have a name. 
		Use them if you need to use a local class only once.
		
		*/
		System.out.println(address.get("city")); //getting actual city from stored json
		address.put("city", "Gurgaon"); //Updating City
		address.put("pincode", "560016"); //Adding new node to json object
		address.remove("locality"); //Removing locality
		System.out.println(address.get("city")); //Getting updated city
		
		//We can pass this address map object to payload argument if required dynamic request.
		//Instead of changing the default stored json.
		
		String updatedAddress = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		
		try {
		RestAssured
			.given().log().all()
			.contentType(ContentType.JSON)
			.body(address)  //We can also pass updatedAddress
			.get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
