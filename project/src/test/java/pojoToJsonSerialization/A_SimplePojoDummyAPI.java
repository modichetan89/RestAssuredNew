package pojoToJsonSerialization;

import io.restassured.RestAssured;

public class A_SimplePojoDummyAPI {
	/*
	{
		  "firstname": "Chetan",
		  "lastname": "Modi",
		  "totalprice": 100,
		  "depositpaid": false,
		  "additionalneeds": "NA"
		}
	*/
	
	public static void main(String[] args) {
		A_SimplePojo s1 = new A_SimplePojo();
		s1.setFirstname("Chetan");
		s1.setLastname("Modi");
		s1.setTotalprice(100);
		s1.setDepositpaid(false);
		s1.setAdditionalneeds("NA");
		
		RestAssured.given().log().all()
			.body(s1)
			.when()
			.get();
	}

}
