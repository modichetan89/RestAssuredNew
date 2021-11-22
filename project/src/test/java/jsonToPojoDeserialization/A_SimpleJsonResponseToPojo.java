package jsonToPojoDeserialization;

import io.restassured.RestAssured;

public class A_SimpleJsonResponseToPojo {
	
	//Sample expected response that we mocked
	/*
	 {
  		"firstname": "Chetan",
  		"lastname": "Modi",
  		"profession": "Tester",
  		"age": 30,
  		"salary": 5000.56
	}
	 */

	public static void main(String[] args) {
		//Mock API URL
		A_SimplePojo response = RestAssured
			.get("https://run.mocky.io/v3/a5b4f9ae-ba90-43aa-acdc-4e35b0fefcfa")
			.as(A_SimplePojo.class);
		
		String name = response.getFirstname();	
		System.out.println(name);
		

	}

}
