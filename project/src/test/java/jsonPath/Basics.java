package jsonPath;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Basics {
	//Root Node - ($) sign
	//Child Node - (.) 
	//Can't use square brackets to represent child node []
	
	/*
	    ClassCastException    - Storing String data value into variable of int data type
		NumberFormatException - When String value cannot be converted to integer  - Integer.parseInt("Chetan")  error, Integer.parseint("123") no error
		NullPointerException  - When trying to retrieve invalid(not existed) key using method getInt("key"), then it will throw null pointer, 
						        except for the String data type it will returns null value getString("key")
	*/
	
	@Test
	public void basicTest() {
		String sampleJson = "{\r\n"
				+ "  \"firstName\" : \"Chetan\",\r\n"
				+ "  \"lastName\" : \"Modi\"\r\n"
				+ "}";
		
		//Get JsonPath instance of given json document
		JsonPath js = new JsonPath(sampleJson);
		String fName = js.getString("firstName");
		Object lName = js.get("lastName");
		System.out.println(fName + "  " + lName);
		
		//Printing complete JSON using root node in 4 ways
		System.out.println((Object)js.get("$")); //Since here we are casting it to object, will get json {}
		System.out.println((Object)js.get()); //Since here we are casting it to object, will get json {}
		System.out.println(js.getString("$")); //It will show data in square brackets [], not a json, to get JSON cast this to Object class
		System.out.println(js.getString("")); //It will show data in square brackets [], not a json, to get JSON cast this to Object class
		
		//ClassCastException
		/*
		 * int i = js.get("firstName"); System.out.println(i);
		 */
		
		//NumberFormatException
		/*
		 * int y = Integer.parseInt("CHETAN"); System.out.println(y); //error
		 */ 		int z = Integer.parseInt("123");
 		System.out.println(z);  // No error
 		
 		//NullPointerException
		/*
		 * Object m = js.getInt("first"); System.out.println(m); //error
		 */ 		Object n = js.getString("last");
 		System.out.println(n); //prints null
		
 		
 		
	}
	
}
