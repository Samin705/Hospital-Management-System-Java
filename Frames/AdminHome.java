package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class AdminHome extends JFrame implements ActionListener
{
	private JButton adddoctorbtn,addreceptionistbtn,adminprofilebtn,logoutbtn;
	private Color color;
	private JLabel backImgLabel;
	private ImageIcon backImg;

	private JPanel panel;
	
	User u;
	
	
	public AdminHome(User u)
	{
		super("Welcome Admin");
		this.setSize(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel=new JPanel();
		panel.setLayout(null);
		
		adddoctorbtn=new JButton("Add Doctor");
		adddoctorbtn.setBounds(120,175,150,40);
		adddoctorbtn.setBackground(Color.GREEN);
		adddoctorbtn.addActionListener(this);
		panel.add(adddoctorbtn);
		
		addreceptionistbtn=new JButton("Add Receptionist");
		addreceptionistbtn.setBounds(330,175,150,40);
		addreceptionistbtn.setBackground(Color.GREEN);
		addreceptionistbtn.addActionListener(this);
		panel.add(addreceptionistbtn);
		
		adminprofilebtn=new JButton("Admin Profile");
		adminprofilebtn.setBounds(540,175,150,40);
		adminprofilebtn.setBackground(Color.GREEN);
		adminprofilebtn.addActionListener(this);
		panel.add(adminprofilebtn);
		
		logoutbtn=new JButton("Logout");
		logoutbtn.setBounds(700,40,150,40);
		logoutbtn.setBackground(Color.RED);
		logoutbtn.addActionListener(this);
		panel.add(logoutbtn);
		
		backImg = new ImageIcon("admin2.jpg");
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
		else if(command.equals(adddoctorbtn.getText()))
		{
			DoctorInfo di=new DoctorInfo(u);
			di.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(adminprofilebtn.getText()))
		{
			AdminProfile ap=new AdminProfile(u);
			ap.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(addreceptionistbtn.getText()))
		{
			ReceptionistInfo ri=new ReceptionistInfo(u);
			ri.setVisible(true);
			this.setVisible(false);
		}
		else{};
		
		
		
		
		
	}
}