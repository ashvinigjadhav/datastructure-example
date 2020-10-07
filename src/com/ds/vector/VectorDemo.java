package com.ds.vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		// Creating Blank Vector v
		Vector v = new Vector();

		// Adding Integer objects in v
		v.add(new Integer(4));
		v.add(new Integer(7));
		v.add(new Integer(6));
		v.add(new Integer(5));
		v.add(new Integer(1));

		// Printing initial elements of Vector v using Enumeration e
		Enumeration e = v.elements();
		Integer i;
		System.out.print("Vector Elements -> ");
		while (e.hasMoreElements()) {
			i = (Integer) e.nextElement();
			System.out.print(i + " ");

		}
		System.out.println("\n");

		// Removing element at index 2
		v.remove(2);

		// After removal printing elements of Vector v using Enumeration e.
		// Re-initialize Enumeration e object
		System.out.print("Vector Elements after removal of 2nd element-> ");
		e = v.elements();
		while (e.hasMoreElements()) {
			i = (Integer) e.nextElement();
			System.out.print(i + " ");
		}
		System.out.println("\n");

		System.out
				.println("Index of Integer 7 -> " + v.indexOf(new Integer(7)));
	}

}
