package com.ds.stack;

import java.util.Enumeration;
import java.util.Stack;


public class StackDemo {

	public static void main(String[] args) {
		//Creating Blank Stack s
	
		Stack<Integer> s = new Stack<Integer>();
		
		//Adding Integer objects in v
		s.push(new Integer(4));
		s.push(new Integer(7));
		s.push(new Integer(6));
		s.push(new Integer(5));
		s.push(new Integer(1));
		
		System.out.println("Top element: " + s.peek());
		
		//Printing initial elements of Stack s using Enumeration e. Though it is Stack 
		//but it will printed as normal array using Enumeration
		Enumeration<Integer> e = s.elements();
		Integer i;
		
		System.out.print("Stack Elements -> ");
		while(e.hasMoreElements()){
			i = (Integer) e.nextElement();
			System.out.print(i + " ");
			
		}
		System.out.println("\n");
		
		//Removing top element of stack
		s.pop();
		
		//After poping top printing elements of Stack s using Enumeration e
		System.out.print("Stack Elements after popping of top-> ");
		e = s.elements();
		while (e.hasMoreElements()) {
			i = (Integer) e.nextElement();
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}
}
