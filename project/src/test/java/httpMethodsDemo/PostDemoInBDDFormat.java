package httpMethodsDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostDemoInBDDFormat {
	
	public static void main(String[] args) {
		
		//Given - Build Request
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
				
		//When - Hit the request to get the response
			.when()
				.post()
					
		//Then - Validation part
			.then()
				.statusCode(200)
				.extract().response().prettyPrint();
	}
}
