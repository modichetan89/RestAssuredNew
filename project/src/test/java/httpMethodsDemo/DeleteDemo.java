package httpMethodsDemo;

import io.restassured.RestAssured;

public class DeleteDemo {

		public static void main(String[] args) {
			
		//Delete may have body or may not have.
		//200 -OK, 204-No content, 202- Accepted, 201 - Created (if another task created by APi to completely delete resource)
			
		//Build Request
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{bookingID}")
				.pathParam("bookingID", 3)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		
		//Hit Request and Get Response
			.when()
				.delete()
		
		//Validate Responses
			.then()
				.log()
				.all()
				.statusCode(201);			
	}

}

