package httpMethodsDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostDemo {

		public static void main(String[] args) {
	
		//Build Request
		RestAssured
			.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")
			.contentType(ContentType.JSON)
		
		//Hit Request and Get Response
			.post()
		
		//Validate Responsess
			.then()
			.log()
			.all()
			.statusCode(200);			
	}

}

