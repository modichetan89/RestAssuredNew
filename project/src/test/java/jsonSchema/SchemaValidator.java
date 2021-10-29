package jsonSchema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidator {
	@Test
	public void responseSchemaValidation() throws FileNotFoundException {
		//using JsonSchemaValidator.matchesJsonSchemaInClasspath if schema is present in src/test/resources folder
		File f = new File(System.getProperty("user.dir")+"/src/test/resources/Resource.json");
		 Response resp = RestAssured.
		 	given()
		 		.log().all()
		 		.baseUri("https://restful-booker.herokuapp.com")
		 		.basePath("/booking")
		 		.body(f)
		 		.contentType(ContentType.JSON)
		 	.when()
		 		.post()
		 	.then()
		 		.log().all()
		 		.statusCode(200)
		 		.body("booking.totalprice", Matchers.is(111))
		 		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema.json"))
		 		.extract().response();
		 		System.out.println(resp.asPrettyString());
		 //Getting totalPrice in response as 111 whereas our schema is expecting maximum price as 100	
	}
	
	
	@Test
	public void responseSchemaValidation2() throws FileNotFoundException {
		//using JsonSchemaValidator.matchesJsonSchema if schema is present at any other location then provide file object with path
		File f = new File(System.getProperty("user.dir")+"/src/test/resources/Resource.json");
		 Response resp = RestAssured.
		 	given()
		 		.log().all()
		 		.baseUri("https://restful-booker.herokuapp.com")
		 		.basePath("/booking")
		 		.body(f)
		 		.contentType(ContentType.JSON)
		 	.when()
		 		.post()
		 	.then()
		 		.log().all()
		 		.statusCode(200)
		 		.body("booking.totalprice", Matchers.is(111))
		 		.body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/test/resources/ResponseSchema.json")))
		 		.extract().response();
		 		System.out.println(resp.asPrettyString());
		 //Getting totalPrice in response as 111 whereas our schema is expecting maximum price as 100	
	}
	
}
