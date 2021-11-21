package jsonResponseDemo;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertNestedJsonObjectResponseToJavaMap {
	
	/* Mock response
	{
  		"id": 1,
  		"first_name": "Chetan",
  		"last_name": "Modi",
  		"email": "modichetan89@gmail.com",
  		"gender": "male",
  		"skills": {
    		"name": "Testing",
    		"proficiency": "Medium"
  		}
	}
		*/
	
	public static void main(String[] args) {
		Map jsonResponseAsMap = RestAssured
			.get("https://run.mocky.io/v3/21c0d1b8-7153-46cb-80ce-1b960e51582c")
			.as(Map.class);
			
			//For simple json object cast to string
			String firstName = (String) jsonResponseAsMap.get("first_name");
			System.out.println(firstName);
			
			//For nested json object cast to map, then cast to string
			@SuppressWarnings("unchecked")
			Map<String, String> skillsMap = (Map<String, String>) jsonResponseAsMap.get("skills");
			String skillName = skillsMap.get("name");
			String skillProficiency = skillsMap.get("proficiency");
			System.out.println(skillName);
			System.out.println(skillProficiency);
	}

}
