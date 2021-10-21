package methodChaining;

class Demo{
	public Demo printName(String name) {
		System.out.println(name);
		return this;   //returning the class object reference
	}
	
	public Demo printAge(int age) {
		System.out.println(age);
		return this;   //returning the current class object reference
	}
	
}

public class customMethodChainingEx {

	public static void main(String[] args) {
		Demo d = new Demo();
		d.printName("Chetan").printAge(31);
		

	}

}
