package jsonPayloadDemo;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;


/*
{
  "id":"1",
  "first_name": "Chetan",
  "last_name": "Modi",
  "married": "true",
  "salary": "123.45",
  "address" : {
    "house_no": "123",
    "street": "xyz",
    "area": "MB",
    "city":"Pune",
    "state":"MH"
  }
}
*/
public class CreateNestedJsonObjectPayloadUsingMap {
	public static void main(String args[]) {
		//Used LinkedHashMap so that keys displays in order in which they inserted
		//Used Object as data type which is super class of all data type classes
		Map<String, Object> jsonObjectPayload = new LinkedHashMap<>();
		jsonObjectPayload.put("id", 1);
		jsonObjectPayload.put("first_name", "Chetan");
		jsonObjectPayload.put("last_name", "Modi");
		jsonObjectPayload.put("married", true);
		jsonObjectPayload.put("salary", 123.45);
		
		//For nested part address we created another Map object
		Map<String, Object> addressMap = new LinkedHashMap<>();
		addressMap.put("house_no", "123");
		addressMap.put("street", "xyz");
		addressMap.put("area", "MB");
		addressMap.put("city", "Pune");
		addressMap.put("state", "MH");
		
		//In parent map add key as address and value as object of address map
		jsonObjectPayload.put("address", addressMap);
		
		RestAssured
			.given().log().all()
			.body(jsonObjectPayload)
			.get();		
	}

}
