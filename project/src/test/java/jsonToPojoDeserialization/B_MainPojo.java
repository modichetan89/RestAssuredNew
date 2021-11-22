package jsonToPojoDeserialization;

public class B_MainPojo {

	private String firstname;
	private String lastname;
	private String profession;
	private int age;
	private double salary;
	private B_NestedPojo address;
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public B_NestedPojo getAddress() {
		return address;
	}
	public void setAddress(B_NestedPojo address) {
		this.address = address;
	}
}
