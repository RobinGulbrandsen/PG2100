package no.bluebit.pojo;

/**
 * Describes a person object in the system.
 *
 */
public class Person {
	
	private String firstname, lastname;
	private int age;
	
	public Person() {
		this("unknown", "unknown", 0);
	}
	
	public Person(String firstname, String lastname, int age) {
		setFirstname(firstname);
		setLastname(lastname);
		setAge(age);
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public int getAge() {
		return age;
	}
	
	/**
	 *
	 * @return The full name of the Person
	 */
	public String getName() {
		return getFirstname() + " " + getLastname();
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() +"\nAge: " + getAge();
	}

}
