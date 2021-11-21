package jsonResponseDemo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class ConvertDynamicJsonResponseToJavaObject {

	/*
	 * Mock response [ { "id": 1, "first_name": "Chetan", "last_name": "Modi",
	 * "email": "modichetan89@gmail.com", "gender": "male" }, { "id": 2,
	 * "first_name": "Ankita", "last_name": "Modi", "email":
	 * "modiankita89@gmail.com", "gender": "female" } ]
	 */

	public static void main(String[] args) {

		// Handling dynamic response using instanceof

		Response response =
				// Url for json response with array - output 2
				RestAssured.get("https://run.mocky.io/v3/abe244fe-9980-4cb4-8920-71deadc26bb7");
		// Url for json response with object - output [id, first_name, last_name, email,
		// gender]
		RestAssured.get("https://run.mocky.io/v3/a461956b-9a7c-4d10-8fa5-efa3beeb4fb8");
		// Comment one of the statement above

		Object responseAsObject = response.as(Object.class);
		if (responseAsObject instanceof List) {
			List responseAsList = (List) responseAsObject;
			System.out.println(responseAsList.size());
		} else if (responseAsObject instanceof Map) {
			Map responseAsMap = (Map) responseAsObject;
			System.out.println(responseAsMap.keySet());
		}

		// Demo of mismatch input exception
		// Response response =
		// RestAssured.get("https://run.mocky.io/v3/abe244fe-9980-4cb4-8920-71deadc26bb7");
		// Map responseAsMap = response.as(Map.class);
		// System.out.println(responseAsMap.keySet());

		// Mismatch Input Exception if we trying to convert the array json response to
		// map
		// Cannot deserialize instance of
		// `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` out of
		// START_ARRAY token

		// Response response2 =
		// RestAssured.get("https://run.mocky.io/v3/a461956b-9a7c-4d10-8fa5-efa3beeb4fb8");
		// List responseAsList = response2.as(List.class);
		// System.out.println(responseAsList.size());
		// Mismatch Input Exception if we trying to convert the object json response to
		// arraylist
		// Cannot deserialize instance of `java.util.ArrayList<java.lang.Object>` out of
		// START_OBJECT token
	}

}
