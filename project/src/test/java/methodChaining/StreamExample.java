package methodChaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	//Expected Output  - Apple Fruit 	Orange Fruit	Banana Fruit	 Grapes Fruit
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Apple", "Oranges", "Banana", "Grapes");
		System.out.println("Before ---> " + names);
		
		//Method 1 Using for each loop
		List<String> customNames =new ArrayList<>();
		String customWord = "Fruit";
		for(String s:names) {
			customNames.add(s + " " + customWord);
		}	
		System.out.println("After  ---> " + customNames);
		
		//Method 2 Using Stream API
		Stream<String> nameStream = names.stream();  //Converting and Storing the list of names to Stream object
		Stream<String> nameStreamCustom = nameStream.map(e -> e + " Fruit"); //mapping the fruit word to each value of stream
		List<String> customNames2 = nameStreamCustom.collect(Collectors.toList()); //collecting the stream as List
		System.out.println("After  ---> " + customNames2); //printing the list
		
		//Chaining the method2 to avoid creating objects (calling one method after another)
		List<String> customNames3 = names.stream().map(e->e + " Fruit").collect(Collectors.toList());
		System.out.println("After  ---> " + customNames3);
	}

}
