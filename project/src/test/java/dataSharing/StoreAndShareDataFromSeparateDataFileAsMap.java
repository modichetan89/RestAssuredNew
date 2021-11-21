package dataSharing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//using data stored in DataStoreAsMap file
public class StoreAndShareDataFromSeparateDataFileAsMap {
	@Test(priority=1)
	public void createBooking() {
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
		
		//DataStoreAsMap.setValue("BookingID", id);
		//Since in above statement we have created our own key which can cause 
		//problem for other team members what is the key name
		//to overcome we can create one Constant interface and define some constants
		//And use these constants here
		DataStoreAsMap.setValue(Constants.BOOKING_ID, id);
	}
	
	@Test(priority=2)
	public void retrieveBooking() {
		//int bookingID = (int) DataStoreAsMap.getValue("BookingID");
		int bookingID = (int) DataStoreAsMap.getValue(Constants.BOOKING_ID);
		Response response = RestAssured
								.given().log().all()
								.get("https://restful-booker.herokuapp.com/booking/"+bookingID)
								.then().log().all().extract().response();
	}
}
