package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class ReceptionistProfile extends JFrame implements ActionListener
{
	private JLabel ridlabel,namelabel,salarylabel;
	private JTextField ridTF,nameTF,salaryTF;
	private JButton updatebtn,loadbtn,refreshbtn,backbtn;
	private JPanel panel;
	
	private User u;
	private Receptionistrepo rr;
	private Userrepo ur;
	
	public ReceptionistProfile(User u)
	{
		super("Receptionist Profile Frame");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		rr = new Receptionistrepo();
		ur = new Userrepo();
		
		panel=new JPanel();
		panel.setLayout(null);
		
		ridlabel=new JLabel("ID");
		ridlabel.setBounds(100,100,100,30);
		panel.add(ridlabel);
		
		ridTF=new JTextField();
		ridTF.setBounds(220,100,100,30);
		panel.add(ridTF);
		
		namelabel=new JLabel("NAME");
		namelabel.setBounds(100,180,100,30);
		panel.add(namelabel);
		
		nameTF=new JTextField();
		nameTF.setBounds(220,180,100,30);
		panel.add(nameTF);
		
		salarylabel=new JLabel("SALARY");
		salarylabel.setBounds(100,250,100,30);
		panel.add(salarylabel);
		
		salaryTF=new JTextField();
		salaryTF.setBounds(220,250,100,30);
		panel.add(salaryTF);
		
		
		updatebtn=new JButton("UPDATE");
		updatebtn.setBounds(400,300,80,30);
		updatebtn.addActionListener(this);	
		updatebtn.setEnabled(false);
		panel.add(updatebtn);
		
		refreshbtn=new JButton("REFRESH");
		refreshbtn.setBounds(500,300,80,30);
		refreshbtn.addActionListener(this);
		refreshbtn.setEnabled(false);
		panel.add(refreshbtn);
		
		loadbtn=new JButton("LOAD");
		loadbtn.setBounds(300,300,80,30);
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
			if(!ridTF.getText().equals("") || !ridTF.getText().equals(null))
			{
				Receptionist r= rr.searchReceptionist(ridTF.getText());
				
				if(r!=null)
				{
					nameTF.setText(r.getname());
					salaryTF.setText(r.getsalary()+"");
					
					ridTF.setEnabled(false);
					nameTF.setEnabled(true);
					salaryTF.setEnabled(true);
					
					loadbtn.setEnabled(true);
					updatebtn.setEnabled(true);
					refreshbtn.setEnabled(true);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(refreshbtn.getText()))
		{
			ridTF.setText("");
			nameTF.setText("");
			salaryTF.setText("");
			
			ridTF.setEnabled(true);
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			refreshbtn.setEnabled(false);
		}
		else if(command.equals(updatebtn.getText()))
		{
			Receptionist r=new Receptionist();
			
			r.setrid(ridTF.getText());
			r.setname(nameTF.getText());
			r.setsalary(Double.parseDouble(salaryTF.getText()));
			
			rr.updateinDB(r);  
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			ridTF.setText("");
			nameTF.setText("");
			salaryTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			refreshbtn.setEnabled(false);
			
			ridTF.setEnabled(true);
			nameTF.setEnabled(true);
			salaryTF.setEnabled(true);
			
		}
		
		else if(command.equals(backbtn.getText()))
		{
			ReceptionistHome rh=new ReceptionistHome(u);
			rh.setVisible(true);
			this.setVisible(false);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}