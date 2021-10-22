package deafultStaticVariableDemo;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BaseClass {
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking";
		System.out.println("In setup method");
		RestAssured.requestSpecification=RestAssured.given().log().all().contentType(ContentType.JSON);
		RestAssured.responseSpecification=RestAssured.expect().statusCode(200);

		//changes in feature1
		//Conflict creation 

	}
	
	
}
