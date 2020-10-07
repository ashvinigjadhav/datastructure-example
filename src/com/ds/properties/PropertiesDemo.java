package com.ds.properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties capitals = new Properties();
		@SuppressWarnings("rawtypes")
		Enumeration states;
		String str;
		
		capitals.setProperty("Maharashtra", "Mumbai");
		capitals.setProperty("MP", "Indore");
		
		states = capitals.keys();
		
		while(states.hasMoreElements()){
			str = (String)states.nextElement();
			System.out.println("" + str + " -> " + capitals.getProperty(str));
		}

	}

}
