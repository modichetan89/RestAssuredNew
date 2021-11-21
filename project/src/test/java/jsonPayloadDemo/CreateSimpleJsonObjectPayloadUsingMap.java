package jsonPayloadDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import io.restassured.RestAssured;

public class CreateSimpleJsonObjectPayloadUsingMap {
	public static void main(String args[]) {
		try {
		mapWithStringValues();
		}
		finally {
		mapWithDifferentDataTypesValues();
		}
	}
	
	public static void mapWithStringValues() {
		Map<String, String> jsonObjectPayload = new HashMap<>();
		jsonObjectPayload.put("id", "1");
		jsonObjectPayload.put("first_name", "Chetan");
		jsonObjectPayload.put("last_name", "Modi");
		jsonObjectPayload.put("married", "true");
		jsonObjectPayload.put("salary", "123.45");
		
		RestAssured
			.given().log().all()
			.body(jsonObjectPayload)
			.get();		
	}
	
	public static void mapWithDifferentDataTypesValues() {
		Map<String, Object> jsonObjectPayload = new TreeMap<>();
		//Used TreeMap so that keys get sort in ascending order
		//We can use LinkedHashMap so that keys displays in order in which they inserted
		//Used Object as data type which is super class of all data type classes
		jsonObjectPayload.put("id", 1);
		jsonObjectPayload.put("first_name", "Chetan");
		jsonObjectPayload.put("last_name", "Modi");
		jsonObjectPayload.put("married", true);
		jsonObjectPayload.put("salary", 123.45);
		
		RestAssured
			.given().log().all()
			.body(jsonObjectPayload)
			.get();		
	}
}
