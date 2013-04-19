package no.bluebit.pojo;

/**
 * 	Describes a person object in the system.
 *	Implements to interfaces
 */
public class Person implements IPerson, Comparable<Person> {
	
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
	
	@Override
	public String toString() {
		return "Name: " + getName() +"\nAge: " + getAge();
	}
	
	@Override
	public boolean equals(Object obj) {
		//check if the object coming in is the same as "this"
		if(obj == this) {
			return true;
		}
		
		//check that the object is a Person
		if(!(obj instanceof Person)) {
			return false;
		}
		
		//the object is now a person and not the same
		Person p = (Person) obj;
		
		//compare key values - name and age
		if(this.age == p.age && this.getName().equals(p.getName())) {
			return true;
		}
		
		//the object is not the same
		return false;
	}
	
	/**
	 * @return The full name of the Person
	 */
	@Override
	public String getName() {
		return getFirstname() + " " + getLastname();
		
	}

	@Override
	public int compareTo(Person o) {
		//uses String's compareTo method based on the last name
		return this.lastname.compareTo(o.lastname);
	}
}
