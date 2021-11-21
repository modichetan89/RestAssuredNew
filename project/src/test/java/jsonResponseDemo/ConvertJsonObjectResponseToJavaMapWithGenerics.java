package jsonResponseDemo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonObjectResponseToJavaMapWithGenerics {
	
	/* Mock response
			[
  {
    "id": 1,
    "first_name": "Chetan",
    "last_name": "Modi",
    "email": "modichetan89@gmail.com",
    "gender": "male"
  },
  {
    "id": 2,
    "first_name": "Ankita",
    "last_name": "Modi",
    "email": "modiankita89@gmail.com",
    "gender": "female"
  }
]
		*/
	
	public static void main(String[] args) {
		List<Map<String, Object>> jsonResponseAsList = RestAssured
			.get("https://run.mocky.io/v3/abe244fe-9980-4cb4-8920-71deadc26bb7")
			.as(new TypeRef<List<Map<String, Object>>>(){});
			
			System.out.println(jsonResponseAsList.size());
			
			Map<String, Object> emp1 = jsonResponseAsList.get(0);
			System.out.println(emp1.get("first_name"));
			
			Map<String, Object> emp2 = jsonResponseAsList.get(1);
			System.out.println(emp2.get("first_name"));
			
	}

}
