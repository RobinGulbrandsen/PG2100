package no.bluebit.objects;

import no.bluebit.pojo.*;

public class Client {
	
	public static void main(String[] args) {
		Person p = new Person("Bruce", "Wayne", 45);
		System.out.println(p);
		
		Superhero batman = new Superhero("Bruce", "Wayne", 45, "Batman");
		System.out.println(batman);
	}
}
