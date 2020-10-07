package com.assignment3.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.assignment3.common.Student;

public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Socket cs = new Socket("localhost", 5000);
			DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
			DataInputStream din = new DataInputStream(cs.getInputStream());

			ObjectOutputStream oout = new ObjectOutputStream(
					cs.getOutputStream());
			ObjectInputStream oin = new ObjectInputStream(cs.getInputStream());
			ArrayList<Student> al =null;
			int ch;
			String name;
			int rollNo;
			double marks;

			// Student class of Client
			Student st = null;
			while (true) {
				System.out.print("\n***** Select Operation *****\n");
				System.out
						.print("\n\t1. Add Student\n\t2. Delete Student\n\t3. Search Student\n\t4. Failed Student\n\t5. Display\n\t6. Exit");
				System.out.print("\nEnter choice: ");
				ch = sc.nextInt();
				dout.writeInt(ch);
				switch (ch) {
				case 1:
					System.out.print("\nEnter Roll No - ");
					rollNo = sc.nextInt();
					System.out.print("\nEnter Name - ");
					name = sc.next();
					System.out.print("\nEnter Marks - ");
					marks = sc.nextDouble();
					st = new Student(rollNo, name, marks);
					oout.writeObject(st);

					
					al = (ArrayList<Student>) oin.readObject();
					System.out.print("\nAdded Succesfully !!!\nUpdated Students List -> \n");
					for(Student s : al){
						System.out.println(s.rollNo + " -:- " + s.name + " -:- " + s.marks);
					}
					break;
				case 2:
					System.out.print("\nEnter rollNo to be deleted : ");
					rollNo = sc.nextInt();
					dout.writeInt(rollNo);
					al = (ArrayList<Student>) oin.readObject();
					System.out.print("\nAdded Succesfully !!!\nUpdated Students List -> \n");
					for(Student s : al){
						System.out.println(s.rollNo + " -:- " + s.name + " -:- " + s.marks);
					}
					break;
				case 3:
					System.out.print("\nEnter rollNo to be searched : ");
					rollNo = sc.nextInt();
					dout.writeInt(rollNo);
					st = (Student) oin.readObject();
					if (st != null) {
						System.out.print("\nSearched Student -> " + st);
					} else {
						System.out.println("User not found !!!");
					}

					break;
				case 4:
					System.out.print("\nEnter passing marks : ");
					double pm = sc.nextDouble();
					dout.writeDouble(pm);
					
					al = (ArrayList<Student>) oin.readObject();
					System.out.print("\nFailed Students List -> \n");
					for(Student s : al){
						System.out.println(s.rollNo + " -:- " + s.name + " -:- " + s.marks);
					}
					break;
				case 5:
					al = (ArrayList<Student>) oin.readObject();
					System.out.print("\nStudents List -> \n");
					for(Student s : al){
						System.out.println(s.rollNo + " -:- " + s.name + " -:- " + s.marks);
					}
					break;
				}
				if (ch == 6) {
					System.out.println(din.readUTF());
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
