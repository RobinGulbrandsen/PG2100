package no.bluebit.objects;

/**
 * 
 * @author Nerdarn
 *	Describes a person object in the system.
 *
 */
public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("", 0);
	}
	
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() +"\nAge: " + getAge();
	}

}
