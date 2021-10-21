package httpMethodsDemo;

import io.restassured.RestAssured;

public class PathParamNamedAndUnnamedBoth {

	public static void main(String[] args) {
		//When having named and unnamed path parameters, then it will take first all named parameters then unnamed parameters
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.pathParam("basePath", "booking")  //Named parameter
				//.pathParam("bookingID", 1)  - This we will pass as unnamed
			.when()
				.get("{basePath}/{bookingID}", 2)  //Unnamed parameter
				//In in above statement we pass one more parameter, then it will be ignored
				//because first param we got from named param, second we got from unnamed, 
				//since our request have only two path param, third argument get ignored
			.then()
				.statusCode(200)
				.log()
				.all();
	}

}
