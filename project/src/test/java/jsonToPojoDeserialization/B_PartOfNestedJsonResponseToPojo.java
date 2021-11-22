package jsonToPojoDeserialization;

import io.restassured.RestAssured;

public class B_PartOfNestedJsonResponseToPojo {
	
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
		B_NestedPojo responseAddress = RestAssured
			.get("https://run.mocky.io/v3/8ff85b5b-5c7e-4769-9e07-d199ac85bf6c")
			.jsonPath()
			.getObject("address", B_NestedPojo.class);
		
		String state = responseAddress.getState();	
		System.out.println(state);
		

	}

}
