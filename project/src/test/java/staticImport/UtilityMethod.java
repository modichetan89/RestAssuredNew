package staticImport;

public class UtilityMethod {
	
	public static String s1 = "Static Import Demo";
	
	public static void doSomething1() {
		System.out.println("doSomething1");
	}
	
	//variable length argument sum method
	static int total=0;
	public static int addSomeThing(int...a) {
		for(int i=0; i<a.length; i++) {
			total = total + a[i];		
			}
		return total;
	}
	

}
