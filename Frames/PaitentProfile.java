package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class PaitentProfile extends JFrame implements ActionListener
{
	private JLabel pidlabel,namelabel,appointmentlabel;
	private JTextField pidTF,nameTF,appointmentTF;
	private JButton loadbtn,backbtn;
	private JPanel panel;
	
	private User u;
	private Paitentrepo pr;
	//private Userrepo ur;
	
	public PaitentProfile(User u)
	{
		super("Patient Profile Frame");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		pr = new Paitentrepo();
		//ur = new Userrepo();
		
		panel=new JPanel();
		panel.setLayout(null);
		
		pidlabel=new JLabel("ID");
		pidlabel.setBounds(100,100,100,30);
		panel.add(pidlabel);
		
		pidTF=new JTextField();
		pidTF.setBounds(220,100,100,30);
		panel.add(pidTF);
		
		namelabel=new JLabel("NAME");
		namelabel.setBounds(100,180,100,30);
		panel.add(namelabel);
		
		nameTF=new JTextField();
		nameTF.setBounds(220,180,100,30);
		panel.add(nameTF);
		
		appointmentlabel=new JLabel("APPOINTMENT");
		appointmentlabel.setBounds(100,250,100,30);
		panel.add(appointmentlabel);
		
		appointmentTF=new JTextField();
		appointmentTF.setBounds(220,250,100,30);
		panel.add(appointmentTF);
		
		loadbtn=new JButton("LOAD");
		loadbtn.setBounds(500,180,80,30);
		loadbtn.addActionListener(this);
		panel.add(loadbtn);
		
		backbtn=new JButton("BACK");
		backbtn.setBounds(400, 350, 80, 30);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(loadbtn.getText()))
		{
			if(!pidTF.getText().equals("") || !pidTF.getText().equals(null))
			{
				Paitent p= pr.searchPaitent(pidTF.getText());
				
				if(p!=null)
				{
					nameTF.setText(p.getname());
					appointmentTF.setText(p.getappointment());
					
					pidTF.setEnabled(false);
					nameTF.setEnabled(true);
					appointmentTF.setEnabled(true);
					
					loadbtn.setEnabled(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(backbtn.getText()))
		{
			DoctorHome rh=new DoctorHome(u);
			rh.setVisible(true);
			this.setVisible(false);
			
		}
	}    
}