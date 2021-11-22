package jsonToPojoDeserialization;

import io.restassured.RestAssured;

public class C_SimpleJsonArrrayResponseToPojoUsingArray {
	
	//Sample expected response that we mocked
	/*
		[
  			{
    			"id": 7,
    			"email": "michael.lawson@reqres.in",
    			"first_name": "Michael",
    			"last_name": "Lawson",
    			"avatar": "https://reqres.in/img/faces/7-image.jpg"
  			},
  			{
    			"id": 8,
    			"email": "lindsay.ferguson@reqres.in",
    			"first_name": "Lindsay",
    			"last_name": "Ferguson",
    			"avatar": "https://reqres.in/img/faces/8-image.jpg"
  			}
		]
	 */

	public static void main(String[] args) {
		//Mock API URL
		C_SimplePojo[] responseArrayData = RestAssured
			.get("https://run.mocky.io/v3/0ac74752-7841-404c-990a-bbf584d9e5aa")
			.as(C_SimplePojo[].class);
		
		System.out.println("No of addresses "+responseArrayData.length);
		System.out.println("Name of second list record "+responseArrayData[1].getFirst_name());
		

	}

}
