package pojoToJsonSerialization;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class D_NestedPojoWithArrayDummyAPI {
	/*
	{
  "page": 2,
  "per_page": 6,
  "total": 12,
  "total_pages": 2,
  "data": [
    {
      "id": 7,
      "email": "michael.lawson@reqres.in",
      "first_name": "Michael",
      "last_name": "Lawson",
      "avatar": "https://reqres.in/img/faces/7-image.jpg"
    },
    {
      "id": 8,
      "email": "lindsay.ferguson@reqres.in",
      "first_name": "Lindsay",
      "last_name": "Ferguson",
      "avatar": "https://reqres.in/img/faces/8-image.jpg"
    }
  ]
}
	*/
	
	public static void main(String[] args) {
		D_NestedPojoData nestedJsonArray1Index = new D_NestedPojoData();
		nestedJsonArray1Index.setId(7);
		nestedJsonArray1Index.setEmail("michael.lawson@reqres.in");
		nestedJsonArray1Index.setFirst_name("Michael");
		nestedJsonArray1Index.setLast_name("Lawson");
		nestedJsonArray1Index.setAvatar("https://reqres.in/img/faces/7-image.jpg");
		
		D_NestedPojoData nestedJsonArray2Index = new D_NestedPojoData();
		nestedJsonArray2Index.setId(8);
		nestedJsonArray2Index.setEmail("lindsay.ferguson@reqres.in");
		nestedJsonArray2Index.setFirst_name("Lindsay");
		nestedJsonArray2Index.setLast_name("Ferguson");
		nestedJsonArray2Index.setAvatar("https://reqres.in/img/faces/8-image.jpg");
		
		List<D_NestedPojoData> listNestedJson = new ArrayList<>();
		listNestedJson.add(nestedJsonArray1Index);
		listNestedJson.add(nestedJsonArray2Index);
		
		D_NestedPojo mainJson  = new D_NestedPojo();
		mainJson.setPage(2);
		mainJson.setPer_page(5);
		mainJson.setTotal(12);
		mainJson.setTotal_pages(54);
		mainJson.setData(listNestedJson);
			
		RestAssured.given().log().all()
			.body(mainJson)
			.when()
			.get();
	}

}
