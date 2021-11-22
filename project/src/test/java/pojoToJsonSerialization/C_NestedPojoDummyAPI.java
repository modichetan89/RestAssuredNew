package pojoToJsonSerialization;

import io.restassured.RestAssured;

public class C_NestedPojoDummyAPI {
	/*
	{
		  "page": 2,
		  "per_page": 5,
		  "total": 12,
		  "total_pages": 54,
		  "data": {
		    "id": 2,
		    "name": "fuchsia rose",
		    "year": 2001,
		    "color": "#C74375",
		    "pantone_value": "17-2031"
		  }
		}
	*/
	
	public static void main(String[] args) {
		C_NestedPojoData nestedJson = new C_NestedPojoData();
		nestedJson.setId(2);
		nestedJson.setName("fuchsia rose");
		nestedJson.setYear(2001);
		nestedJson.setColor("#C74375");
		nestedJson.setPantone_value("17-2031");
		
		C_NestedPojo mainJson  = new C_NestedPojo();
		mainJson.setPage(2);
		mainJson.setPer_page(5);
		mainJson.setTotal(12);
		mainJson.setTotal_pages(54);
		mainJson.setData(nestedJson);
			
		RestAssured.given().log().all()
			.body(mainJson)
			.when()
			.get();
	}

}
