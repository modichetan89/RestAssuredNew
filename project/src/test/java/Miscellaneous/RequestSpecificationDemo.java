package Miscellaneous;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void setUpReqSpec() {
		requestSpecification = RestAssured.given();
		requestSpecification
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void createBooking() {
		RestAssured
		.given()
			.spec(requestSpecification)
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
		.when()
			.post()
		.then()
			.statusCode(200);
	}
	
	@Test
	public void updateBooking() {
		RestAssured
		.given()
			.spec(requestSpecification)
			.basePath("booking/1")
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
		.when()
			.put()
		.then()
			.log()
			.all()
			.statusCode(200);			
	}

}
