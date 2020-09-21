package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class DoctorHome extends JFrame implements ActionListener
{
	private JButton viewpatientbtn,doctorprofilebtn,logoutbtn;
	private JLabel backImgLabel;
	private ImageIcon backImg;
	private JPanel panel;
	private Color color;
	
	User u;
	
	
	public DoctorHome(User u)
	{
		super("Welcome Doctor");
		this.setSize(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel=new JPanel();
		panel.setLayout(null);
		
		viewpatientbtn=new JButton("View Patient");
		viewpatientbtn.setBounds(200,200,150,40);
		viewpatientbtn.setBackground(Color.cyan);
		viewpatientbtn.addActionListener(this);
		panel.add(viewpatientbtn);
		
		doctorprofilebtn=new JButton("Doctor Profile");
		doctorprofilebtn.setBounds(450,200,150,40);
		doctorprofilebtn.setBackground(Color.cyan);
		doctorprofilebtn.addActionListener(this);
		panel.add(doctorprofilebtn);
		
		logoutbtn=new JButton("Logout");
		logoutbtn.setBounds(700,40,150,40);
		logoutbtn.setBackground(Color.RED);
		logoutbtn.addActionListener(this);
		panel.add(logoutbtn);
		
		backImg = new ImageIcon("doctor.jpg");
		Image rawImage = backImg.getImage();
		Image resizedImage = rawImage.getScaledInstance(900,450,Image.SCALE_SMOOTH);
		
		backImg = new ImageIcon(resizedImage);
		backImgLabel = new JLabel(backImg);
		backImgLabel.setBounds(0,0,900,450);
		panel.add(backImgLabel);
		
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		String command = ae.getActionCommand();
		
		if(command.equals(logoutbtn.getText()))
		{
			Login lf = new Login();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(viewpatientbtn.getText()))
		{
			PaitentProfile pp=new PaitentProfile(u);
			pp.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(doctorprofilebtn.getText()))
		{
			DoctorProfile dp=new DoctorProfile(u);
			dp.setVisible(true);
			this.setVisible(false);
		}
		else{};
}
}