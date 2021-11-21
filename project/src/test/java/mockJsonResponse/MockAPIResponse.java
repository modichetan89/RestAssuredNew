package mockJsonResponse;

import io.restassured.RestAssured;

public class MockAPIResponse {

	public static void main(String[] args) {
		// https://designer.mocky.io/
		/*
		   {
  			"id": 1,
  			"first_name": "Chetan",
  			"last_name": "Modi",
  			"email": "modichetan89@gmail.com",
  			"gender": "male"
		   }
		*/
		
		//https://run.mocky.io/v3/5a5b5423-fbd6-41fb-9f7c-b99e5b319d7c
		
		RestAssured
			.given().log().all()
			.get("https://run.mocky.io/v3/5a5b5423-fbd6-41fb-9f7c-b99e5b319d7c")
			.then().log().all();

	}

}
