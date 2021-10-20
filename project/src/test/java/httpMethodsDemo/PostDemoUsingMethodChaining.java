package httpMethodsDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostDemoUsingMethodChaining {

		public static void main(String[] args) {
	
		//Build Request
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec = requestSpec.log().all();
		requestSpec.baseUri("https://restful-booker.herokuapp.com/");
		requestSpec.basePath("booking");
		requestSpec.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		requestSpec.contentType(ContentType.JSON);
		
		//Hit Request and Get Response
		Response response = requestSpec.post();
		
		//Validate Response
		ValidatableResponse valResp = response.then();
		valResp.log().all();
		try {
			valResp.statusCode(401);
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}
				
	}

}

