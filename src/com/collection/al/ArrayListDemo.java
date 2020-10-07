package com.collection.al;

import java.util.*;

public class ArrayListDemo {

	public static void main(String args[]) {
		// Creating blank ArrayList al
		ArrayList<String> al = new ArrayList<String>();

		// Adding object in ArrayList al
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");

		// Traversing list through Iterator
		Iterator<String> itr =  al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// For Another Way to iterate the element
		/*
		 * for(String obj:list) { System.out.println(obj); }
		 */
	}
}