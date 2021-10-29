package miscellaneous;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeaderOverwriteWithRequestSpecification {
	@Test
	public void overWriteHeaderOfReqSpec() {
		RequestSpecification reqSpec1 = RestAssured.given()
				.header("header1", "value1")
				.header("header2", "value2");
		
		RequestSpecification reqSpec2 = RestAssured.given()
				.header("header1", "valueX")
				.header("header3", "value3");
		
		Response response = RestAssured
			.given()
				.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header1")))
				.spec(reqSpec1)
				.spec(reqSpec2)
				.log()
				.all()
			.when()
				.get();
		
		System.out.println(response);
	}
}
