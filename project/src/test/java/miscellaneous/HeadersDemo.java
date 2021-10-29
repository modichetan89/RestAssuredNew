package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeadersDemo {
	/*
	//Single Header
	@Test
	public void passHeaders() {
		RestAssured
			.given()
				.log().all()
				.header("Header1","Value1")
			.when()
				.post()
			.then()
				.statusCode(200);
	}
	
	//Header with Multiple values
	@Test
	public void passMultipleHeadersOneKeyMultipleValues() {
		RestAssured
			.given()
				.log().all()
				.header("Header1","Value1", "Value2", "Value3")
			.when()
				.post()
			.then()
				.statusCode(200);
	}
	
	
	
	//Header with Multiple values using header Object
		@Test
		public void passHeaderUsingHeaderObject() {
			Header header = new Header("Header1","Value1");
			RestAssured
				.given()
					.log().all()
					.header(header)
				.when()
					.post()
				.then()
					.statusCode(200);
		}
		
		//Headers with Multiple values
		@Test
		public void passMultipleHeadersDifferentKeyValue() {
			RestAssured
				.given()
					.log().all()
					.headers("h1","v1","h2","v2")
				.when()
					.post()
				.then()
					.statusCode(200);
		}
		
		//Headers with Multiple values using Maps
		@Test
		public void passMultipleHeadersUsingMaps() {
			
			Map<String, String> headerMap = new HashMap<>(); 
			headerMap.put("h1", "v1");
			headerMap.put("h2", "v2");
			headerMap.put("h3", "v3");
			
			RestAssured
				.given()
					.log().all()
					.headers(headerMap)
				.when()
					.post()
				.then()
					.statusCode(200);
		}
		
	
	//Header with Multiple values using headers Object that takes header objects
			@Test
			public void passHeaderUsingHeadersObjectWithHeader() {
				Header header1 = new Header("Header1","Value1");
				Header header2 = new Header("Header2","Value2");
				Headers headers = new Headers(header1, header2);
				RestAssured
					.given()
						.log().all()
						.headers(headers)
					.when()
						.post()
					.then()
						.statusCode(200);
			}
			
			//Header with Multiple values using headers Object that takes list of header
			@Test
			public void passHeaderUsingHeadersObjectWithListOfHeader() {
				Header header1 = new Header("Header1","Value1");
				Header header2 = new Header("Header2","Value2");
				List<Header> allHeaders = new ArrayList<>();
				allHeaders.add(header1);
				allHeaders.add(header2);
				Headers headers = new Headers(allHeaders);
				RestAssured
					.given()
						.log().all()
						.headers(headers)
					.when()
						.post()
					.then()
						.statusCode(200);
			}
			*/
			//Overwrite the first header if header key is same for two headers
			@Test
			public void overwriteHeaders() {
				RestAssured
					.given()
						.log().all()
							
						//It overwrite the first value with second one. Only display last header.
						  .config(RestAssuredConfig .config() .headerConfig(HeaderConfig
						  .headerConfig() .overwriteHeadersWithName("Header1", "Header3")))
						  
						  
						//It will show all headers as individual
						  .config(RestAssuredConfig .config() .headerConfig(HeaderConfig
						  .headerConfig() .mergeHeadersWithName("Header1")))
						 
					
						//Note - Since we have two config here, 
						//rest assured always considers last config as previous config get overridden by last config. 
						//so only last config get apply
						//Accept and ContentType headers are never merged, they always overwritten
						
						.header("Header1","Value1", "Valuex")
						.header("Header1","Value2")
						.header("Header2","Value1", "Valuex")
						.header("Header2","Value2")
						.header("Header3","Value1")
						.header("Header3","Value2")
					.when()
						.post()
					.then()
						.statusCode(200);
			}
}
