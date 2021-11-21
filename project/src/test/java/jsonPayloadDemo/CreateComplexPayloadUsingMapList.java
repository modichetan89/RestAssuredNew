package jsonPayloadDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;


/*
 * [
  {
    "id": 1,
    "first_name": "Chetan",
    "last_name": "Modi",
    "email": "modichetan89@gmail.com",
    "gender": "male",
    "mobile": [
      "1234567890",
      "2234567890"
    ],
    "skills": {
      "name": "Testing",
      "proficiency": "Expert"
    }
  },
  {
    "id": 2,
    "first_name": "Ankita",
    "last_name": "Modi",
    "email": "modiankita89@gmail.com",
    "gender": "female",
    "skills": [
      {
        "name": "Testing",
        "proficiency": "Medium"
      },
      {
        "name": "Java",
        "proficiency": "Medium",
        "certifications": [
          "OCJP11",
          "OCJP12"
        ]
      }
    ]
  }
]
 * */
public class CreateComplexPayloadUsingMapList {

	public static void main(String[] args) {
		List<Map<String, Object>> finalList = new ArrayList<>();
		
		//first array data
		Map<String, Object> firstEmpData = new LinkedHashMap<>();
		firstEmpData.put("id", 1);
		firstEmpData.put("first_name", "Chetan");
		firstEmpData.put("last_name", "Modi");
		firstEmpData.put("email", "modichetan89@gmail.com");
		firstEmpData.put("gender", "male");
		
		//List<String> mobileFirstEmp = new ArrayList<>();
		//mobileFirstEmp.add("1234567890");
		//mobileFirstEmp.add("2234567890");
		
		List<String> mobileFirstEmp = Arrays.asList("1234567890", "2234567890");
		
		firstEmpData.put("mobile", mobileFirstEmp);
		
		Map<String, Object> skillsSet = new LinkedHashMap<>();
		skillsSet.put("name", "Testing");
		skillsSet.put("proficiency", "Expert");
		
		firstEmpData.put("skills", skillsSet);
		
		//Second array data
		Map<String, Object> secondEmpData = new LinkedHashMap<>();
		secondEmpData.put("id", 2);
		secondEmpData.put("first_name", "Ankita");
		secondEmpData.put("last_name", "Modi");
		secondEmpData.put("email", "modiankita89@gmail.com");
		secondEmpData.put("gender", "female");
		
		List<Map<String, Object>> skillsList = new ArrayList<>();
		Map<String, Object> skillsSet2Testing = new LinkedHashMap<>();
		skillsSet2Testing.put("name", "Testing");
		skillsSet2Testing.put("proficiency", "Medium");
		
		Map<String, Object> skillsSet2Java = new LinkedHashMap<>();
		skillsSet2Java.put("name", "Java");
		skillsSet2Java.put("proficiency", "Medium");
		List<String> cert = new ArrayList<>();
		cert.add("OCJP11");
		cert.add("OCJP12");
		skillsSet2Java.put("certifications", cert);
		
		skillsList.add(skillsSet2Testing);
		skillsList.add(skillsSet2Java);
		
		secondEmpData.put("skills", skillsList);
		
		finalList.add(firstEmpData);
		finalList.add(secondEmpData);
		
		
		//Rest Assured code
		RestAssured
			.given().log().all()
			.body(finalList)
			.get();
		
	}

}
