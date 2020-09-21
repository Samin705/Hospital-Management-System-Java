package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class PaitentInfo extends JFrame implements ActionListener
{
	private JLabel pidlabel,namelabel,appointmentlabel;
	private JTextField pidTF,nameTF,appointmentTF;
	private JButton insertbtn,deletebtn,updatebtn,loadbtn,refreshbtn,backbtn;
	private JPanel panel;
	
	private User u;
	private Paitentrepo pr;
	//private Userrepo ur;
	
	
	public PaitentInfo(User u)
	{
		super("Patient Info Frame");
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
		
		insertbtn=new JButton("INSERT");
		insertbtn.setBounds(100,300,80,30);
		insertbtn.addActionListener(this);
		panel.add(insertbtn);
		
		deletebtn=new JButton("DELETE");
		deletebtn.setBounds(200,300,80,30);
		deletebtn.addActionListener(this);
		deletebtn.setEnabled(false);
		panel.add(deletebtn);
		
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
					
					loadbtn.setEnabled(false);
			        updatebtn.setEnabled(true);
			        insertbtn.setEnabled(false);
			        refreshbtn.setEnabled(true);
			        deletebtn.setEnabled(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertbtn.getText()))
		{
			Paitent p=new Paitent();
			//User u1=new User();
			
			
			p.setpid(pidTF.getText());
			p.setname(nameTF.getText());
			p.setappointment(appointmentTF.getText());
			
			//u1.setuid(pidTF.getText());
			
			pr.insertinDB(p);  
			//ur.insertuser(u1);  
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+pidTF.getText());
			
			pidTF.setText("");
			nameTF.setText("");
			appointmentTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		
		else if(command.equals(refreshbtn.getText()))
		{
			pidTF.setText("");
			nameTF.setText("");
			appointmentTF.setText("");
			
			
			pidTF.setEnabled(true);
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		else if(command.equals(updatebtn.getText()))
		{
			Paitent p=new Paitent();
			
			p.setpid(pidTF.getText());
			p.setname(nameTF.getText());
			p.setappointment(appointmentTF.getText());
			
			pr.updateinDB(p); 
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			pidTF.setText("");
			nameTF.setText("");
			appointmentTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
			
			pidTF.setEnabled(true);
			nameTF.setEnabled(true);
			appointmentTF.setEnabled(true);
			
		}
		
		else if(command.equals(deletebtn.getText()))
		{
			pr.deletefromDB(pidTF.getText()); 
			//ur.deleteuser(pidTF.getText());  
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			pidTF.setText("");
			nameTF.setText("");
			appointmentTF.setText("");
			
			pidTF.setEnabled(true);
			nameTF.setEnabled(true);
			appointmentTF.setEnabled(true);
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		else if(command.equals(backbtn.getText()))
		{
			ReceptionistHome rh=new ReceptionistHome(u);
			rh.setVisible(true);
			this.setVisible(false);
			
		}
	}
}