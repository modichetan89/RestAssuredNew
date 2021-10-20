package httpMethodsDemo;

import io.restassured.RestAssured;

public class GetDemoInBDDFormat {

	public static void main(String[] args) {
		RestAssured
			//Build Request
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{id}")
				.pathParam("id", "1")
			//Hit request and get reponse
			.when()
				.get()
			//Validate response
			.then()
				.log().all()
				.statusCode(200);
	}

}
