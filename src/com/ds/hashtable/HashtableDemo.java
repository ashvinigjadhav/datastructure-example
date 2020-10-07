package com.ds.hashtable;

import java.util.*;

public class HashtableDemo {

	public static void main(String args[]) {
		Hashtable ht = new Hashtable();

		ht.put(new Integer(1), new Double(2.3));
		ht.put(new Integer(3), new Double(5.6));
		ht.put(new Integer(2), new Double(3.9));
		ht.put(new Integer(6), new Double(7.2));

		System.out.println("Hashtable -> " + ht);

		System.out.println("Value of Australia -> " + ht.get("Australia"));

		// hashCode() method returns HashCode of Hashtable ht object
		System.out.println("HashCode of Hashtable ht -> " + ht.hashCode());
	}
}
