package jsonPath;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonPathForComplexJsonArray2 {
	
	@Test(priority=1)
	public void complexJsonArray() {
		 String s = "[\r\n"
		 		+ "                {\r\n"
		 		+ "                    \"id\": \"abcat0100000\",\r\n"
		 		+ "                    \"name\": [ \r\n"
		 		+ "						{\r\n"
		 		+ "							\"skuName\" : \"TV & Home Theater\",\r\n"
		 		+ "							\"details\" : \"detail 1\"\r\n"
		 		+ "						},\r\n"
		 		+ "						{\r\n"
		 		+ "							\"skuName\" : \"TV & Home Equipments\",\r\n"
		 		+ "							\"details\" : \"detail 2\"\r\n"
		 		+ "						},\r\n"
		 		+ "						{\r\n"
		 		+ "							\"skuName1\" : \"TV \",\r\n"
		 		+ "							\"details1\" : \"detail 3\"\r\n"
		 		+ "						}\r\n"
		 		+ "					],\r\n"
		 		+ "                    \"createdAt\": \"2016-11-17T17:57:04.285Z\",\r\n"
		 		+ "                    \"updatedAt\": \"2016-11-17T17:57:04.285Z\"\r\n"
		 		+ "                },\r\n"
		 		+ "                {\r\n"
		 		+ "                    \"id\": \"pcmcat158900050018\",\r\n"
		 		+ "                    \"name\": [ \r\n"
		 		+ "						{\r\n"
		 		+ "							\"skuName\" : \"TV & Home Theater\",\r\n"
		 		+ "							\"details\" : \"detail 1\"\r\n"
		 		+ "						},\r\n"
		 		+ "						{\r\n"
		 		+ "							\"skuName\" : \"TV & Home Equipments\",\r\n"
		 		+ "							\"details\" : \"detail 2\"\r\n"
		 		+ "						}\r\n"
		 		+ "					],\r\n"
		 		+ "                    \"createdAt\": \"2016-11-17T17:57:04.899Z\",\r\n"
		 		+ "                    \"updatedAt\": \"2016-11-17T17:57:04.899Z\"\r\n"
		 		+ "                }\r\n"
		 		+ "            ]";
		 
		  JsonPath js = new JsonPath(s);	  
		  System.out.println(js.getString("[0].name[1].skuName")); //return only sku name present at first index inside name
		  System.out.println(js.getList("[0].name.skuName")); //return all sku name present inside name
		  System.out.println(js.getList("name.skuName")); //return all sku name present inside all names
	}
}
