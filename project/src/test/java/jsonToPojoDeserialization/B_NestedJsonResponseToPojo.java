package jsonToPojoDeserialization;

import io.restassured.RestAssured;

public class B_NestedJsonResponseToPojo {
	
	//Sample expected response that we mocked
	/*
	 {
  		"firstname": "Chetan",
  		"lastname": "Modi",
  		"profession": "Tester",
  		"age": 30,
  		"salary": 5000.56,
  		"address": {
    		"houseno": "344",
    		"locality": "nanded",
    		"city": "pune",
    		"state": "MH"
  			}
		}
	 */

	public static void main(String[] args) {
		//Mock API URL
		B_MainPojo response = RestAssured
			.get("https://run.mocky.io/v3/8ff85b5b-5c7e-4769-9e07-d199ac85bf6c")
			.as(B_MainPojo.class);
		
		String name = response.getFirstname();
		System.out.println(name);
		
		String city = response.getAddress().getCity();	
		System.out.println(city);
		

	}

}
