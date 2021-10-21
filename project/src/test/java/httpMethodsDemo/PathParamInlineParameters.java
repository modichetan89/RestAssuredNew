package httpMethodsDemo;

import io.restassured.RestAssured;

public class PathParamInlineParameters {

	public static void main(String[] args) {
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				//.basePath("{basePath}/{bookingID}")
				//.pathParam("basePath", "booking")
				//.pathParam("bookingID", 1)
				//instead of above named parameters, we can directly pass these values in overloaded get method which we call as unnamed parameters
			.when()
				.get("{basePath}/{bookingID}","booking", 1)
			.then()
				.statusCode(200)
				.log()
				.all();
	}

}
