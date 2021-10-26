package jsonPath;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonPathForSimpleJsonArray {
	
	@Test(priority=1)
	public void simpleJsonArray() {
		 String s = "[\r\n"
		 		+ "	\"10\",\r\n"
		 		+ "	\"20\",\r\n"
		 		+ "	\"30\",\r\n"
		 		+ "	\"40\",\r\n"
		 		+ "	\"50\"\r\n"
		 		+ "]";
		 
		  JsonPath js = new JsonPath(s);	  
		  System.out.println(js.getString("$"));
		  System.out.println(js.getString("[0]"));
	}
	
	@Test(priority=2)
	public void nestedJSONArray() {
		 String s = "[	\r\n"
		 		+ "	[	\r\n"
		 		+ "	\"10\",\r\n"
		 		+ "	\"20\",\r\n"
		 		+ "	\"30\",\r\n"
		 		+ "	\"40\",\r\n"
		 		+ "	\"50\"\r\n"
		 		+ "	],\r\n"
		 		+ "	[	\r\n"
		 		+ "	\"100\",\r\n"
		 		+ "	\"200\",\r\n"
		 		+ "	\"300\",\r\n"
		 		+ "	\"400\",\r\n"
		 		+ "	\"500\"\r\n"
		 		+ "	]\r\n"
		 		+ "]\r\n"
		 		+ "";
		 
		  JsonPath js = new JsonPath(s);	  
		  System.out.println(js.getString("$"));
		  System.out.println(js.getString("[0]"));
		  System.out.println(js.getString("[1]"));
		  System.out.println(js.getString("[1][2]"));
		  System.out.println(js.getList("$").size());

		  List<Object> internalList = (List<Object>) js.getList("$").get(1);
		  System.out.println(internalList.size());
	}

}
