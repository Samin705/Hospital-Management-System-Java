package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class ReceptionistHome extends JFrame implements ActionListener
{
	private JButton addpatientbtn,viewreceptionist,logoutbtn;
	private Color color;
	private JLabel backImgLabel;
	private ImageIcon backImg;
	private JPanel panel;
	
	User u;
	
	
	public ReceptionistHome(User u)
	{
		super("Welcome Receptionist");
		this.setSize(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel=new JPanel();
		panel.setLayout(null);
		
		addpatientbtn=new JButton("Add Patient");
		addpatientbtn.setBounds(200,200,150,40);
		addpatientbtn.setBackground(Color.cyan);
		addpatientbtn.addActionListener(this);
		panel.add(addpatientbtn);
		
		viewreceptionist=new JButton("View Receptionist");
		viewreceptionist.setBounds(450,200,150,40);
		viewreceptionist.setBackground(Color.cyan);
		viewreceptionist.addActionListener(this);
		panel.add(viewreceptionist);
		
		logoutbtn=new JButton("Logout");
		logoutbtn.setBounds(700,40,150,40);
		logoutbtn.setBackground(Color.RED);
		logoutbtn.addActionListener(this);
		panel.add(logoutbtn);
		
		backImg = new ImageIcon("receptionist.jpg");
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
		else if(command.equals(viewreceptionist.getText()))
		{
			ReceptionistProfile rp=new ReceptionistProfile(u);
			rp.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(addpatientbtn.getText()))
		{
			PaitentInfo pi=new PaitentInfo(u);
			pi.setVisible(true);
			this.setVisible(false);
		}
		else{};
	}
}