package miscellaneous;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationDemo {
	
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setUpReqSpec() {
		responseSpecification = RestAssured.expect();
		responseSpecification
			.statusCode(200)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L));	
	}
	
	@Test
	public void createBooking() {
		RestAssured
		.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON)
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
			.log().all()
			.spec(responseSpecification);
	}
	
	@Test
	public void updateBooking() {
		RestAssured
		.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON)
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
			.log().all()
			.spec(responseSpecification);			
	}

}
