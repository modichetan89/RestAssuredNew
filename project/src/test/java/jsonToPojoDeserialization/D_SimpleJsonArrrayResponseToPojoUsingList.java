package jsonToPojoDeserialization;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class D_SimpleJsonArrrayResponseToPojoUsingList {
	
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
		List<D_SimplePojo> responseArrayData = RestAssured
			.get("https://run.mocky.io/v3/0ac74752-7841-404c-990a-bbf584d9e5aa")
			.as(new TypeRef<List<D_SimplePojo>>() {} );
		
		System.out.println("No of addresses "+responseArrayData.size());
		System.out.println("Name of second list record "+responseArrayData.get(1).getFirst_name());
		

	}

}
