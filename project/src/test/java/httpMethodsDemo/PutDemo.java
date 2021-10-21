package httpMethodsDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutDemo {

		public static void main(String[] args) {
		
		//Build Request
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/1")
				.contentType(ContentType.JSON)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
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
			
		//Hit Request and Get Response
			.when()
				.put()
		
		//Validate Responsess
			.then()
				.log()
				.all()
				.statusCode(200);			
	}

}

