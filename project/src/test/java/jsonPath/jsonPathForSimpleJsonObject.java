package jsonPath;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonPathForSimpleJsonObject {
	String jsonObject = "{\r\n"
			+ "            \"id\": 3041141,\r\n"
			+ "            \"name\": \"Sony - ES SXRD 3D-Ready 4K Home Theater Projector - Black\",\r\n"
			+ "            \"type\": \"HardGood\",\r\n"
			+ "            \"price\": 27999.98,\r\n"
			+ "            \"upc\": \"027242873193\",\r\n"
			+ "            \"shipping\": {\r\n"
			+ "							\"oneday\" : \"150\",\r\n"
			+ "							\"normal\" : \"free\"\r\n"
			+ "						},\r\n"
			+ "            \"description\": \"4K (4096 x 2160) resolution2000 lumens brightness16:9 aspect ratio\",\r\n"
			+ "            \"manufacturer\": \"Sony\",\r\n"
			+ "            \"model\": \"VPLVW1100ES\",\r\n"
			+ "            \"url\": \"http://www.bestbuy.com/site/sony-es-sxrd-3d-ready-4k-home-theater-projector-black/3041141.p?id=1219086346401&skuId=3041141&cmp=RMXCC\",\r\n"
			+ "            \"image\": \"http://img.bbystatic.com/BestBuy_US/images/products/3041/3041141_sa.jpg\",\r\n"
			+ "            \"createdAt\": \"2016-11-17T18:02:21.601Z\",\r\n"
			+ "            \"updatedAt\": \"2016-11-17T18:02:21.601Z\",\r\n"
			+ "            \"categories\": [\r\n"
			+ "                {\r\n"
			+ "                    \"id\": \"abcat0100000\",\r\n"
			+ "                    \"name\": [ \r\n"
			+ "						{\r\n"
			+ "							\"skuName1\" : \"TV & Home Theater\"\r\n"
			+ "						},\r\n"
			+ "						{\r\n"
			+ "							\"skuName2\" : \"TV & Home Equipments\"\r\n"
			+ "						}\r\n"
			+ "					],\r\n"
			+ "                    \"createdAt\": \"2016-11-17T17:57:04.285Z\",\r\n"
			+ "                    \"updatedAt\": \"2016-11-17T17:57:04.285Z\"\r\n"
			+ "                },\r\n"
			+ "                {\r\n"
			+ "                    \"id\": \"pcmcat158900050008\",\r\n"
			+ "                    \"name\": \"Projectors & Screens\",\r\n"
			+ "                    \"createdAt\": \"2016-11-17T17:57:04.899Z\",\r\n"
			+ "                    \"updatedAt\": \"2016-11-17T17:57:04.899Z\"\r\n"
			+ "                },\r\n"
			+ "                {\r\n"
			+ "                    \"id\": \"pcmcat158900050018\",\r\n"
			+ "                    \"name\": \"Projectors\",\r\n"
			+ "                    \"createdAt\": \"2016-11-17T17:57:04.899Z\",\r\n"
			+ "                    \"updatedAt\": \"2016-11-17T17:57:04.899Z\"\r\n"
			+ "                }\r\n"
			+ "            ]\r\n"
			+ "}";
	
	@Test(priority=1) 
	public void simpleJsonEx() {	
		JsonPath js = new JsonPath(jsonObject);
		int id = js.getInt("id");
		String name = js.getString("name");
		System.out.println(id + " --> "+ name);
	}
	
	@Test(priority=2)
	public void nestedJsonEx() {
		JsonPath js = new JsonPath(jsonObject);
		String shippingNormal = js.getString("shipping.normal");
		System.out.println(shippingNormal);
		String shippingAll = js.getString("shipping");
		System.out.println(shippingAll);
	}
	
	@Test(priority=3)
	public void nestedJsonWithArrayAndNestedArrayEx() {
		JsonPath js = new JsonPath(jsonObject);
		
		String firstCategoryID = js.getString("categories.id[0]");
		System.out.println(firstCategoryID);
		
		String allCategoryID = js.getString("categories.id");
		System.out.println(allCategoryID); 
		
		String secondCategoryAllDetails = js.getString("categories[1]");
		System.out.println(secondCategoryAllDetails);
		
		String firstCategorySecondName = js.getString("categories[0].name[1]");
		System.out.println(firstCategorySecondName);
		
		System.out.println(js.getList("categories").size());
	}
}
