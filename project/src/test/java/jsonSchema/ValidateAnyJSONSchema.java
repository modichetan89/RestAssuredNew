package jsonSchema;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidateAnyJSONSchema {
	@Test
	public void validateJSONSchema() {
		String reqJson = "{\r\n"
				+ "    \"firstname\": \"Jim\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}";
		
		MatcherAssert.
			assertThat(reqJson, JsonSchemaValidator.matchesJsonSchemaInClasspath("RequestSchema.json"));
		//It will get fail because lastName length is 5 and we have schema with minLength as 7 and maxLength as 10
	}
	
}
