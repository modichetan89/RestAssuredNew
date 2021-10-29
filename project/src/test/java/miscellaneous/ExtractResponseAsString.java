package miscellaneous;

//User A changes
//User B from github

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseAsString {

	public static void main(String[] args) {
		String responseBody = 
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/")
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
				.contentType(ContentType.JSON)
			.when()
				.post()
			.then()
				.extract()
				//.body() //Even if don't mention body extract will by default extract response body. It is optional to use.
				.asPrettyString(); // It print json in format way
				//.asString(); // It print json in single line
		
		System.out.println(responseBody);
	}

}
