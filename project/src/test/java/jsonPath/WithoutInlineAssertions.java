package jsonPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class WithoutInlineAssertions {
	@Test
	public void demo() {
		String response = "";
		response = RestAssured
				.given()
					.log().all()
					.baseUri("https://restful-booker.herokuapp.com/auth")
					.contentType(ContentType.JSON)
					.body("{\r\n"
							+ "    \"username\" : \"admin\",\r\n"
							+ "    \"password\" : \"password123\"\r\n"
							+ "}")
				.when()
					.post()
				.then()
					.log().all()
					.extract()
					.asString();
		
		JsonPath jsonPath = new JsonPath(response);
		Assert.assertNotNull(jsonPath.get("token"));
	}
	
}
