package dataSharingITestContext;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingDetails {
	
	@Test
	public void getBookingID(ITestContext context) {
		int id = 
				RestAssured
				.given()
					.log()
					.all()
					.baseUri("https://restful-booker.herokuapp.com")
					.basePath("/booking")
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
				.when()
					.post()
				.then()
					.log()
					.all()
					.statusCode(200)
					.extract()
					.jsonPath()
					.getInt("bookingid");
		
		context.setAttribute("booking_id", id);
	}
}
