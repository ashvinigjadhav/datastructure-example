package com.collection.ll;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating blank LinkedList ll
		LinkedList<String> ll = new LinkedList<String>();

		// Adding object in LinkedList ll
		ll.add("Ravi");
		ll.add("Vijay");
		ll.add("Ravi");
		ll.add("Ajay");

		// Traversing list through Iterator
		/*
		 * Iterator itr = ll.iterator(); while (itr.hasNext()) {
		 * System.out.println(itr.next()); }
		 */

		// For Another Way to iterate the element using for-each loop
		for (String obj : ll) {
			System.out.println(obj);
		}
	}

}
