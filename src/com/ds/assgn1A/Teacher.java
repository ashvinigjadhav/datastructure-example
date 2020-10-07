package com.ds.assgn1A;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class Teacher {
	
	/*static Vector studentDb =new Vector();*/
	static ArrayList<Student> studentDb = new ArrayList<Student>();
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Operations obj = new Operations();
		int rollNo;
		Student s;
		while(true){
			System.out.println("Select Operations");
			System.out.println("1. Add New Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Search Student");
			System.out.println("4. Failed Students");
			System.out.println("5. Exit");
			System.out.println("Enter Choice : ");
			int ch;
			ch = sc.nextInt();
			switch(ch){
				case 1:
					s = obj.addStudent();
					if(s != null){
						studentDb.add(s);
						System.out.println("Student added successfully !!!");
					}
					break;
				case 2:
					System.out.println("Enter rollNo to be deleted: ");
					rollNo = sc.nextInt();
					boolean deleted = obj.deleteStudent(rollNo);
					if(deleted){
						System.out.println("Roll no " + rollNo + " deleted successfully !!!");
						System.out.println("After Deletion updated list is - ");
						obj.display(studentDb);
					}
					break;
				case 3:
					System.out.println("Enter rollNo to be searched: ");
					rollNo = sc.nextInt();
					s = obj.searchStudent(rollNo);
					if(s == null){
						System.out.println("Roll No " + rollNo + " not found");
					}else{
						System.out.println(s);
					}
					
					break;
				case 4:
					System.out.println("Enter passing marks: ");
					double pm = sc.nextDouble();
					/*Vector v = obj.failedStudents(pm);*/
					ArrayList<Student> v= obj.failedStudents(pm);
					System.out.println("Failed Student's list -> ");
					obj.display(v);
					break;
			}
			if(ch == 5){
				System.out.println("Bye Bye !!!");
				break;
			}
		}
		sc.close();
	}
}




class Operations{
	
	void display(ArrayList<Student> v){
		/*Enumeration e = v.elements();
		while(e.hasMoreElements()){
			System.out.println("" + (Student)e.nextElement());
		}*/
		for(Student s : v)
		{
			System.out.println(s);
		}
	}
	
	Student addStudent(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("RollNo: ");
		int rollNo = sc.nextInt();
		
		System.out.println("Name: ");
		String name = sc.next();
		
		System.out.println("Marks: ");
		double marks = sc.nextDouble();
		
		Student obj = new Student(rollNo, name, marks);
		sc.close();
		
		return obj;
	}
	
	boolean deleteStudent(int rollNo){
		/*Enumeration e = Teacher.studentDb.elements();*/
		boolean status = false;
		
		for(Student s :Teacher.studentDb)
		{
			if(s.rollNo == rollNo){
				int index = Teacher.studentDb.indexOf(s);
				Teacher.studentDb.remove(index);
				status = true;
				break;
			}
		}
		/*while(e.hasMoreElements()){
			Student s = (Student) e.nextElement();
			if(s.rollNo == rollNo){
				int index = Teacher.studentDb.indexOf(s);
				Teacher.studentDb.remove(index);
				status = true;
			}
		}*/
		return status;
	}
	
	Student searchStudent(int rollNo){
		Student st = null;
		
		for (Student s: Teacher.studentDb)
		{
			if(s.rollNo == rollNo){
				st=s;
				break;
			}
		}
		/*Enumeration e = Teacher.studentDb.elements();*/
		
		/*while(e.hasMoreElements()){
			st = (Student) e.nextElement();
			if(st.rollNo == rollNo){
				break;
			}
		}*/		
		return st;
	}
	
	ArrayList<Student> failedStudents(double pm){
		/*Vector v = new Vector();*/
		ArrayList<Student> v = new ArrayList<Student>();
		
		/*Enumeration e = Teacher.studentDb.elements();
		
		while(e.hasMoreElements()){
			Student st = (Student) e.nextElement();
			if(st.marks < pm){
				v.add(st);
			}
		}*/
		
		for(Student s : Teacher.studentDb)
		{

			if(s.marks < pm){
				v.add(s);
			}
		}
		
		return v;
	}
}
