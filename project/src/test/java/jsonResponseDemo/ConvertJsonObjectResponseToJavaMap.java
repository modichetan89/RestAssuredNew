package jsonResponseDemo;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJsonObjectResponseToJavaMap {
	
	/* Mock response
	{
		  "id": 1,
		  "first_name": "Chetan",
		  "last_name": "Modi",
		  "email": "modichetan89@gmail.com",
		  "gender": "male"
		}
		*/
	
	public static void main(String[] args) {
		Map jsonResponseAsMap = RestAssured
			.get("https://run.mocky.io/v3/5a5b5423-fbd6-41fb-9f7c-b99e5b319d7c")
			.as(Map.class);
		
			String firstName = (String) jsonResponseAsMap.get("first_name");
			System.out.println(firstName);
			
			jsonResponseAsMap.keySet().forEach(k -> System.out.println(k));
	}

}
