package httpMethodsDemo;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class PathParamUsingMap {

	public static void main(String[] args) {

		Map<String, Object> pathParams = new HashMap<>();
		pathParams.put("basePath", "booking");
		pathParams.put("bookingID", "3");
		
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basePath}/{bookingID}")
				.pathParams(pathParams)
			.when()
				.get()
			.then()
				.statusCode(200)
				.log()
				.all();
	}

}
