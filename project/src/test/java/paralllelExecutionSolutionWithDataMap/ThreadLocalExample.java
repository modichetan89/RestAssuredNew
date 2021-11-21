package paralllelExecutionSolutionWithDataMap;

public class ThreadLocalExample {

	public static void main(String[] args) {
		
		ThreadLocal<Object> counter1 = new ThreadLocal<>();
		counter1.set("Chetan");
		System.out.println((String) counter1.get());
		
		counter1.remove();
		System.out.println((String) counter1.get());
		
		
		ThreadLocal<Object> counter2 = ThreadLocal.withInitial(() -> "Ankita");
		System.out.println((String) counter2.get());
		//it is similar to ThreadLocal1 first three lines, 
		//we are setting default value after creating ThreadLocal object
	
		ThreadLocal<String> counter3 = new ThreadLocal<>();
		counter3.set("Hridaan");
		System.out.println(counter3.get());
		//Since Generics is provided as String, we do not need to use cast with string here
		
	}

}
