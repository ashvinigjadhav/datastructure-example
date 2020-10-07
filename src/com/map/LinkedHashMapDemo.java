package com.map;

import java.util.*;

public class LinkedHashMapDemo {
	public static void main(String args[]) {
		// Create and populate linked hash map
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(101, "Let us C");
		map.put(102, "Operating System");
		map.put(103, "Data Communication and Networking");
	 
		for(Map.Entry m: map.entrySet())
		{
			 System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println("Values before remove: " + map);
		// Remove value for key 102
		map.remove(102);
		System.out.println("Values after remove: " + map);
	}
}