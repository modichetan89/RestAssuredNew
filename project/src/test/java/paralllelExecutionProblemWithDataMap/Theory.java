package paralllelExecutionProblemWithDataMap;

public class Theory {
	
	/*
	 * Problem
	 * When we run two classes in parallel, then due to create booking method booking
	 * id is generated for both classes, but at time of calling get api that is using
	 * that id, we get last generated id for both classes retrieve methods.
	 * 
	 * if we run testng classes in parallel then same thread will execute all the 
	 * @Test method of that class.
	 * 
	 * Solution -
	 * ThreadLocal - It enables you to create variables that can only be read and write by the same thread. 
	 * If two threads are executing the same code and that code has a reference to a ThreadLocal 
	 * variable then the two threads can't see the local variable of each other.
	 * It makes the data thread safe.
	 * If we generated data using thread1, then retrieve method only read that thread1 data
	 * If we generated data using thread2, then retrieve method only read that thread2 data
	 *  
	 * */
	
}
