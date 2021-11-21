package paralllelExecutionSolutionWithDataMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//using data stored in DataStoreAsMap file
public class UsingThreadLocalWithMapModule2 {
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
		
		ThreadLocalDataStoreAsMap.setValue(Constants.BOOKING_ID, id);
		
		System.out.println("Thread ID is --> " + Thread.currentThread().getId());
		
		System.out.println("Created Booking ID is --> " +ThreadLocalDataStoreAsMap.getValue(Constants.BOOKING_ID));
	}
	
	@Test(priority=2)
	public void retrieveBooking() throws InterruptedException {
		Thread.sleep(20000);
		
		System.out.println("Thread ID is --> " + Thread.currentThread().getId());
		
		System.out.println("Retrieved Booking ID is --> " +ThreadLocalDataStoreAsMap.getValue(Constants.BOOKING_ID));
	
		int bookingID = (int) ThreadLocalDataStoreAsMap.getValue(Constants.BOOKING_ID);
		Response response = RestAssured
								.given().log().all()
								.get("https://restful-booker.herokuapp.com/booking/"+bookingID)
								.then().log().all().extract().response();
	}
}
