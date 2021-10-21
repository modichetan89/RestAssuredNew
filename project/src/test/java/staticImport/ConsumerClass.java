package staticImport;
import static staticImport.UtilityMethod.*;

public class ConsumerClass {

	public static void main(String[] args) {
		//If we import the static package then we can call the static methods of that class without using the className
		//because this import, imports all the public static method and variables of mentioned class to current class
		//Simple import imports the classs from another package whereas static import imports the data members of the class
		System.out.println(s1);
		
		doSomething1();
		
		int sum = addSomeThing(4,5,1);
		System.out.println(sum);
		
		
	}

}
