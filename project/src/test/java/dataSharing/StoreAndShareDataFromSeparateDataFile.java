package dataSharing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//using data stored in DataStore file
public class StoreAndShareDataFromSeparateDataFile {
	@Test(priority=1)
	public void createBooking() {
		DataStore.booking_Id = 
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
	}
	
	@Test(priority=2)
	public void retrieveBooking() {
		Response response = RestAssured
								.given().log().all()
								.get("https://restful-booker.herokuapp.com/booking/"+DataStore.booking_Id)
								.then().log().all().extract().response();
	}
}
