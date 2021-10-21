package httpMethodsDemo;

import io.restassured.RestAssured;

public class PathParamDemo {

	public static void main(String[] args) {
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basePath}/{bookingID}")
				.pathParam("basePath", "booking")
				.pathParam("bookingID", 1)
			.when()
				.get()
			.then()
				.statusCode(200)
				.log()
				.all();
	}

}
