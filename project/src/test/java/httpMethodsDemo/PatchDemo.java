package httpMethodsDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchDemo {

		public static void main(String[] args) {
		//If your requirement is just to modify any one or two values of payload not complete payload, then we can use Patch method
		//although we can use Put also by changing only specific value from complete payload.
		
		//Build Request
		RestAssured
			.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/1")
			.body("{\r\n"
				+ "    \"firstname\" : \"Chetan\",\r\n"
				+ "    \"lastname\" : \"Modi\"\r\n"
				+ "}")
			.contentType(ContentType.JSON)	
			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
			
		//Hit Request and Get Response
			.patch()
		
		//Validate Responsess
			.then()
			.log()
			.all()
			.statusCode(200);			
	}

}

