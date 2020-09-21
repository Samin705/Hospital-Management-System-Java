package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class AdminProfile extends JFrame implements ActionListener
{
	
	private JLabel aidlabel,namelabel,salarylabel;
	private JTextField aidTF,nameTF,salaryTF;
	private JButton updatebtn,loadbtn,refreshbtn,backbtn;
	private JPanel panel;
	
	private User u;
	private Adminrepo ar;
	private Userrepo ur;
	
	public AdminProfile(User u)
	{
		super("Admin Profile Frame");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		ar = new Adminrepo();
		ur = new Userrepo();
		
		panel=new JPanel();
		panel.setLayout(null);
		
		
		
		aidlabel=new JLabel("ID");
		aidlabel.setBounds(100,100,100,30);
		panel.add(aidlabel);
		
		aidTF=new JTextField();
		aidTF.setBounds(220,100,100,30);
		panel.add(aidTF);
		
		namelabel=new JLabel("NAME");
		namelabel.setBounds(100,180,100,30);
		panel.add(namelabel);
		
		nameTF=new JTextField();
		nameTF.setBounds(220,180,100,30);
		panel.add(nameTF);
		
		salarylabel=new JLabel("Salary");
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
			if(!aidTF.getText().equals("") || !aidTF.getText().equals(null))
			{
				Admin a= ar.searchAdmin(aidTF.getText());
				
				if(a!=null)
				{
					nameTF.setText(a.getname());
					salaryTF.setText(a.getsalary()+"");
					
					aidTF.setEnabled(false);
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
			aidTF.setText("");
			nameTF.setText("");
			salaryTF.setText("");
			
			aidTF.setEnabled(true);
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			refreshbtn.setEnabled(false);
		}
		else if(command.equals(updatebtn.getText()))
		{
			Admin a=new Admin();
			
			a.setaid(aidTF.getText());
			a.setname(nameTF.getText());
			a.setsalary(Double.parseDouble(salaryTF.getText()));
			
			ar.updateinDB(a);  
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			aidTF.setText("");
			nameTF.setText("");
			salaryTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			refreshbtn.setEnabled(false);
			
			aidTF.setEnabled(true);
			nameTF.setEnabled(true);
			salaryTF.setEnabled(true);
			
		}
		
		else if(command.equals(backbtn.getText()))
		{
			AdminHome ah=new AdminHome(u);
			ah.setVisible(true);
			this.setVisible(false);
			
		}
		
	}
	
	
	
	
}
	