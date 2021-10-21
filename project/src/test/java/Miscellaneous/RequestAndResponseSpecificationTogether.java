package Miscellaneous;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecificationTogether {
	//We can directly pass the requestSpecification object to given() method and can skip step .spec(requestSpecification)
	//.given(requestSpecification)
	//But in then() method we cannot directly pass response specification.
	//Also if we make all things like basePath, body of request as part of request specification,
	//then we can pass both request and response specification in given method.
	//.given(requestSpecification, responseSpecification), make sure next statement after this should be http method call like .post()
	//.log().all()  //log.all not work with response specification, we need to pass this in individual methods
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setUpReqSpec() {
		requestSpecification = RestAssured.given();
		requestSpecification
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON);
		
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
			.log()
			.all()
			.spec(responseSpecification);
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
			.spec(responseSpecification);			
	}

}
