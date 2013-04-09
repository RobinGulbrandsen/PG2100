package no.bluebit.pojo;

public class Superhero extends Person{
	
	private String alias;
	
	public Superhero() {
		this("", "", 0, "");
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
