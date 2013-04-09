package no.bluebit.pojo;

/**
 * Supehero is an extention of Person class
 */
public class Superhero extends Person{
	
	private String alias;
	
	public Superhero() {
		this("unknown", "unknown", 0, "unknown");
	}
	
	public Superhero(String firstname, String lastname, int age, String alias) {
		super(firstname, lastname, age);
		setAlias(alias);
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String toString() {
		return super.toString() + "\nAlias: " + getAlias();
	}
}
