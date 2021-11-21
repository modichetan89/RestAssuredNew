package jsonResponseDemo;

import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayResponseToJavaList {
	
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
		Map<String, Object> jsonResponseAsMap = RestAssured
			.get("https://run.mocky.io/v3/5a5b5423-fbd6-41fb-9f7c-b99e5b319d7c")
			.as(new TypeRef<Map<String, Object>>(){});
		
			String firstName = (String) jsonResponseAsMap.get("first_name");
			System.out.println(firstName);
			
			Set<String> keys = jsonResponseAsMap.keySet();
			for(String a: keys) {
				System.out.println(a + " --> " + jsonResponseAsMap.get(a));
			}
	}

}
