package chainingDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FBScript {
	//In chaining each methods of class return the object, which helps in reducing the statements by not creating object 
	//of all classes and chain methods from different classes without storing the values again and again.
	public static void main(String[] args) {
		new Login().loginToApp().sendFriendReq().sendMessage();
		/*
		 * String s = "Automation"; IntStream input = s.chars(); Stream<Character>
		 * charStream = input.mapToObj(ch -> (char)ch); Map<Character, Long> output =
		 * charStream.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		 * System.out.println(output);
		 * 
		 */
	}

}
