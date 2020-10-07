package com.DataStructureProject.Assignment4.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.INITIALIZE;

import com.DataStructureProject.Assignment4.common.Student;

public class ClientUI extends JFrame implements ActionListener{

	JPanel mainPanel, addFormPanel;
	JButton addMainBtn, deleteMainBtn, searchMainBtn, failMainBtn, addBtn;
	JTextField rollNoTF, nameTF, marksTF;
	JLabel rollNoL, nameL, marksL;
	DataOutputStream dout = null;
	DataInputStream din = null;
	ObjectOutputStream oout = null;
	ObjectInputStream oin = null;
	Socket cs = null;

	public void myFrame(){
		setSize(400, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0, 400, 400);
			mainPanel.setLayout(null);
			
				addMainBtn = new JButton("Add");
				addMainBtn.setBounds(30, 30, 100, 100);
				addMainBtn.addActionListener(this);
				
				mainPanel.add(addMainBtn);
			
			
				deleteMainBtn = new JButton("Delete");
				deleteMainBtn.setBounds(180, 30, 100, 100);
				deleteMainBtn.addActionListener(this);
				
				mainPanel.add(deleteMainBtn);
			
				searchMainBtn = new JButton("Search");
				searchMainBtn.setBounds(30, 160, 100, 100);
				searchMainBtn.addActionListener(this);
				
				mainPanel.add(searchMainBtn);
				
			
				failMainBtn = new JButton("Failed");
				failMainBtn.setBounds(180, 160, 100, 100);
				failMainBtn.addActionListener(this);
				
				mainPanel.add(failMainBtn);
			
			mainPanel.setVisible(true);
			add(mainPanel);
			
			
			addFormPanel = new JPanel();
			addFormPanel.setBounds(0, 0, 400, 400);
			addFormPanel.setLayout(null);
			
				rollNoL = new JLabel("Roll No.: ");
				rollNoL.setBounds(10, 30, 100, 30);
				
				addFormPanel.add(rollNoL);
				
				rollNoTF = new JTextField();
				rollNoTF.setBounds(60, 30, 100, 30);
				
				addFormPanel.add(rollNoTF);
				
				nameL = new JLabel("Name: ");
				nameL.setBounds(10, 80, 100, 30);
				
				addFormPanel.add(nameL);
				
				nameTF = new JTextField();
				nameTF.setBounds(60, 80, 100, 30);
				
				addFormPanel.add(nameTF);
				
				marksL = new JLabel("Marks: ");
				marksL.setBounds(10, 130, 100, 30);
				
				addFormPanel.add(marksL);
				
				
				marksTF = new JTextField();
				marksTF.setBounds(60, 130, 100, 30);
				
				addFormPanel.add(marksTF);
				
				addBtn = new JButton("Add");
				addBtn.setBounds(30, 180, 100, 30);
				addBtn.addActionListener(this);
				
				addFormPanel.add(addBtn);
			
			addFormPanel.setVisible(false);
			this.add(addFormPanel);
		
		setVisible(true);
	}
	
	public void initialize(){
		try {
			cs = new Socket("localhost", 5000);
			dout = new DataOutputStream(cs.getOutputStream());
			din = new DataInputStream(cs.getInputStream());

			oout = new ObjectOutputStream(
					cs.getOutputStream());
			oin = new ObjectInputStream(cs.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientUI obj = new ClientUI();
		obj.initialize();
		obj.myFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == addMainBtn){
			addFormPanel.setVisible(true);
			mainPanel.setVisible(false);
		}else if(arg0.getSource() == addBtn){
			try {
				dout.writeInt(1);
			
				Student st = null;
				int rollNo = Integer.parseInt(rollNoTF.getText());
				String name = nameTF.getText();
				double marks = Double.parseDouble(marksTF.getText());
				
				st = new Student(rollNo, name, marks);
				oout.writeObject(st);
				
				ArrayList<Student> al = (ArrayList<Student>) oin.readObject(); 
				
				String print = "";
				for(Student s : al){
					print = print + "\n" + s.rollNo + " -:- " + s.name + " -:- " + s.marks;
				}
				JOptionPane.showMessageDialog(this, "Added Successfully !!!\n" + print, "Current Students List", JOptionPane.INFORMATION_MESSAGE);
				
				mainPanel.setVisible(true);
				addFormPanel.setVisible(false);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
