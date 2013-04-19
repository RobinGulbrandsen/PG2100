package no.bluebit.arraylist;

import java.util.ArrayList;

import no.bluebit.pojo.Person;

public class Client {
	
	public static void main(String[] args) {
		//Creates a list with objects. The list's length is undefined
		ArrayList<Person> list = new ArrayList<Person>();
		
		//check that the list is emtpy
		System.out.println("The list is emtpy?: " + list.isEmpty());
		
		//Adds a new element to the list
		list.add(new Person("Bruce", "Wayne", 45));
		
		//Calls the size method to get the length of the list [1]
		System.out.println("The list contains " + list.size() + " person(s).\n");
		
		list.add(new Person("Richard", "Grason", 25));
		
		//compare the two persons
		Person p1 = list.get(0);
		Person p2 = list.get(1);
		System.out.println(p1.getName() + " is the same person as " + p2.getName() + ": " + p1.equals(p2));
		System.out.println(p1.getName() + " is the same person as " + p1.getName() + ": " + p1.equals(p1) + "\n");
			
		//clear the list
		list.clear();
		
		//check that the list is cleared
		if(list.isEmpty()) {
			System.out.println("The list is now empty");
		}
		
		/*
		 * For more methods:
		 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html#method_summary
		 * remember CRUD (create, read, update, delete)
		 */
	}

}
