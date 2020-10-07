package com.DataStructureProject.Assignment4.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DataStructureProject.Assignment4.common.Student;

public class Operations {
	int addStudent(Student st) {
		int rowsInserted = 0;
		
	    Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into Student(rollNo, name, marks) values(?,?,?)");
			ps.setInt(1, st.rollNo);
			ps.setString(2, st.name);
			ps.setDouble(3, st.marks);
			
			rowsInserted = ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsInserted;
	}
	
	int deleteStudent(int rollNo) {
		int rowsDeleted = 0;
		
		Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from Student where rollNo = ?");
			ps.setInt(1, rollNo);
			
			rowsDeleted = ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsDeleted;
	}
	
	Student searchStudent(int rollNo){
		Student st = null;
		
		Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Student where rollNo = ?");
			ps.setInt(1, rollNo);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				st = new Student(rs.getInt("rollNo"), rs.getString("name"), rs.getDouble("marks"));
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
	}
	
	ArrayList<Student> failedStudents(double pm){
		ArrayList<Student> failed = new ArrayList<Student>();
		
		Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Student where marks < ?");
			ps.setDouble(1, pm);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Student st = new Student(rs.getInt("rollNo"), rs.getString("name"), rs.getDouble("marks"));
				failed.add(st);
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return failed;
	}
	
	ArrayList<Student> display(){
		ArrayList<Student> allData = new ArrayList<Student>();
		
		Connection con = DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Student st = new Student(rs.getInt("rollNo"), rs.getString("name"), rs.getDouble("marks"));
				allData.add(st);
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allData;
	}
}
