package com.DataStructureProject.Assignment4.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.DataStructureProject.Assignment4.common.Student;

public class ServerDemo {
	int port;
	ServerSocket ss = null;
	Socket cs = null;
	Operations obj = null;
	ExecutorService pool = null;
	
	public ServerDemo(int port){
		this.port = port;
		obj = new Operations();
		pool = Executors.newFixedThreadPool(5);
	}
	
	public void startServer(){
		try {
			//creating one server socket 
			ss = new ServerSocket(5000);
			//for accepting multiple clients
			while(true){
				System.out.println("Server waiting for client....");
				cs = ss.accept();
				
				System.out.println("Got one client.Creating thread for this client...");
				ServerThreadBody runnable = new ServerThreadBody(cs, obj, this);
				//assigning thread to pool
				pool.execute(runnable);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerDemo(5000).startServer();
	}

}



class ServerThreadBody implements Runnable{
	ServerDemo server = null;
	Socket cs = null;
	DataOutputStream dout = null;
	DataInputStream din = null;
	ObjectOutputStream oout = null;
	ObjectInputStream oin = null;
	Student st = null;
	Operations obj = null;
	
	ServerThreadBody(Socket cs, Operations obj, ServerDemo server) {
		// TODO Auto-generated constructor stub
		this.cs = cs;
		this.obj = obj;
		this.server = server;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			dout = new DataOutputStream(cs.getOutputStream());
			din = new DataInputStream(cs.getInputStream());
			
			oout = new ObjectOutputStream(
					cs.getOutputStream());
			oin = new ObjectInputStream(cs.getInputStream());
			
			
			int rollNo;
			
	
			while (true) {
	
				int ch = din.readInt();
				if (ch == 1) {
					// Reading com.server.Student Object from client
	
					st = (Student) oin.readObject();
	
					// Calling addStudent() of com.server.Operations class
					obj.addStudent(st);
					oout.writeObject(obj.display());
				} else if (ch == 2) {
					// Reading rollNo from client for deleting
					rollNo = din.readInt();
	
					// Calling addStudent() of com.server.Operations class
					obj.deleteStudent(rollNo);
					oout.writeObject(obj.display());
				} else if (ch == 3) {
					// Reading rollNo from client for deleting
					rollNo = din.readInt();
	
					// Calling addStudent() of com.server.Operations class
					st = obj.searchStudent(rollNo);
					if (st != null) {
						// Writing searched Student object back to client
						oout.writeObject(st);
					} else {
						// Writing ArrayList al object back to client
						oout.writeObject(null);
					}
				} else if (ch == 4) {
					// Reading rollNo from client for deleting
					double pm = din.readDouble();
	
					// Calling addStudent() of com.server.Operations class
					ArrayList<Student> failed = obj.failedStudents(pm);
					oout.writeObject(failed);
				} else if (ch == 5) {
					oout.writeObject(obj.display());
				}else if(ch == 6){
					dout.writeUTF("Bye Bye Client from server!!! ");
					System.out.println("Socket Closed !!!");
					cs.close();
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