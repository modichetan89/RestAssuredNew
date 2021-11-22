package dynamicPayloadJackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonToPojoAddress {
	public static void main(String args[]) throws StreamReadException, DatabindException, IOException{
		
		ObjectMapper objMapper = new ObjectMapper();
		PojoAddress address = objMapper.readValue(
				new File(System.getProperty("user.dir")
						+"\\src\\test\\resources\\jsonPayloads\\address.json"), 
						PojoAddress.class);
		
		System.out.println(address.getCity());
		address.setCity("Gurgaon");
		System.out.println(address.getCity());
		
		//We can pass this address object to payload argument if required dynamic request.
		//Instead of changing the default stored json.
		
		try {
		RestAssured
			.given().log().all()
			.contentType(ContentType.JSON)
			.body(address)
			.get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Second approach is to serialize java object to string
		finally {
		String updatedPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		RestAssured
			.given().log().all()
			.contentType(ContentType.JSON)
			.body(updatedPayload)
			.get();
		}
		
	}
}
