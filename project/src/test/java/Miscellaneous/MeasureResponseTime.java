package Miscellaneous;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class MeasureResponseTime {
	public static void main(String[] args) {
		Response response = RestAssured
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
		.when()
			.post();
		
		//Hamcrest Matchers
		ValidatableResponse a = response.then().time(Matchers.lessThan(5000L));
		ValidatableResponse b = response.then().time(Matchers.greaterThan(2000L));
		ValidatableResponse c = response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(2000L)));
		ValidatableResponse d = response.then().time(Matchers.greaterThan(2L), TimeUnit.SECONDS);
		
		long responseTimeInMS = response.time();
		System.out.println("Response in MS is --> " + responseTimeInMS);
		
		long responseTimeInSeconds = response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response in Seconds is --> " + responseTimeInSeconds);
		
		long responseTimeInMS1 = response.getTime();
		System.out.println("Response in MS is --> " + responseTimeInMS1);
		
		long responseTimeInSeconds1 = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("Response in Seconds is --> " + responseTimeInSeconds1);
	}
}
