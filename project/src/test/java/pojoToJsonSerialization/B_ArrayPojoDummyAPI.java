package pojoToJsonSerialization;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class B_ArrayPojoDummyAPI {
	/*
	[
	  {
	    "firstname": "Chetan",
	    "lastname": "Modi",
	    "totalprice": 100,
	    "depositpaid": false,
	    "additionalneeds": "NA"
	  },
	  {
	    "firstname": "Sally",
	    "lastname": "Brown",
	    "totalprice": 111,
	    "depositpaid": true,
	    "additionalneeds": "Breakfast"
	  }
	]
	*/
	
	public static void main(String[] args) {
		B_ArrayPojo jsonObject1 = new B_ArrayPojo();
		jsonObject1.setFirstname("Chetan");
		jsonObject1.setLastname("Modi");
		jsonObject1.setTotalprice(100);
		jsonObject1.setDepositpaid(false);
		jsonObject1.setAdditionalneeds("NA");
		
		B_ArrayPojo jsonObject2 = new B_ArrayPojo();
		jsonObject2.setFirstname("Sally");
		jsonObject2.setLastname("Brown");
		jsonObject2.setTotalprice(111);
		jsonObject2.setDepositpaid(true);
		jsonObject2.setAdditionalneeds("Breakfast");
		
		List<B_ArrayPojo> jsonArrayObject = new ArrayList<>();
		jsonArrayObject.add(jsonObject1);
		jsonArrayObject.add(jsonObject2);
		
		
		RestAssured.given().log().all()
			.body(jsonArrayObject)
			.when()
			.get();
	}

}
