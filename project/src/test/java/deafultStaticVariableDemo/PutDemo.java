package deafultStaticVariableDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutDemo {

		@Test
		public void modifyResource() {
			//Build Request
		RestAssured
			.given()
				.basePath("booking/1") //overriding basePath of setUp method
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n"
					+ "    \"firstname\" : \"Chetan\",\r\n"
					+ "    \"lastname\" : \"Modi\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Dinner\"\r\n"
					+ "}")
			
		//Hit Request and Get Response
			.when()
				.put()
		
		//Validate Responsess
			.then()
				.log().all()
				.extract().body().asPrettyString();
	}
}

