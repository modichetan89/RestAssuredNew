package jsonPayloadDemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
/*
[
 {
   "id": 1,
   "first_name": "Hildegarde",
   "last_name": "Quartley",
   "email": "hquartley0@hexun.com",
   "gender": "Bigender"
 },
 {
   "id": 2,
   "first_name": "Julissa",
   "last_name": "Lorkin",
   "email": "jlorkin1@instagram.com",
   "gender": "Non-binary"
 }
]
*/		
public class CreateSimpleJsonArrayPayloadUsingMap {
	public static void main(String args[]) {
		Map<String, Object> emp1 = new LinkedHashMap<>();
		emp1.put("id", 1);
		emp1.put("first_name", "Hildegarde");
		emp1.put("last_name", "Quartley");
		emp1.put("email", "hquartley0@hexun.com");
		emp1.put("gender", "Bigender");
		
		Map<String, Object> emp2 = new LinkedHashMap<>();
		emp2.put("id", 2);
		emp2.put("first_name", "Julissa");
		emp2.put("last_name", "Lorkin");
		emp2.put("email", "jlorkin1@instagram.com");
		emp2.put("gender", "Non-binary");
		
		//Now since we have to add above object in array we can store it in ArrayList
		List<Map<String, Object>> allEmp = new ArrayList<>();
		allEmp.add(emp1);
		allEmp.add(emp2);
			
		RestAssured
			.given().log().all()
			.body(allEmp)
			.get();		
	}
}
