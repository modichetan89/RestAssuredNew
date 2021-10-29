package jsonPath;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class WithInlineAssertions {
	@Test
	public void demo() {
		 RestAssured
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
					.body("token.length()", Matchers.is(15))
					.body("token.length()", Matchers.equalTo(15))
					.body("token", Matchers.notNullValue())
		 			.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}
	
	
	@Test
	public void demoWithArrays() {
		RestAssured
				.given()
					.log().all()
					.baseUri("https://restful-booker.herokuapp.com/booking")
				.when()
					.get()
				.then()
					.log().all()
					.body("bookingid", Matchers.hasItems(3,4));
					//.body("[0].bookingid", Matchers.hasItem(3));
	
	}
}
