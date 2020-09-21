package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class DoctorInfo extends JFrame implements ActionListener
{
	
	private JLabel didlabel,namelabel,feelabel,desiglabel;
	private JTextField didTF,nameTF,feeTF,desigTF;
	private JButton insertbtn,deletebtn,updatebtn,loadbtn,refreshbtn,backbtn;
	private JPanel panel;
	
	private User u;
	private Doctorrepo dr;
	private Userrepo ur;
	
	public DoctorInfo(User u)
	{
		super("Doctor Info Frame");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		dr = new Doctorrepo();
		ur = new Userrepo();
		
		panel=new JPanel();
		panel.setLayout(null);
		
		
		
		didlabel=new JLabel("ID");
		didlabel.setBounds(100,100,100,30);
		panel.add(didlabel);
		
		didTF=new JTextField();
		didTF.setBounds(220,100,100,30);
		panel.add(didTF);
		
		namelabel=new JLabel("NAME");
		namelabel.setBounds(100,150,100,30);
		panel.add(namelabel);
		
		nameTF=new JTextField();
		nameTF.setBounds(220,150,100,30);
		panel.add(nameTF);
		
		feelabel=new JLabel("FEE");
		feelabel.setBounds(100,250,100,30);
		panel.add(feelabel);
		
		feeTF=new JTextField();
		feeTF.setBounds(220,250,100,30);
		panel.add(feeTF);
		
		desiglabel=new JLabel("DESIGNATION");
		desiglabel.setBounds(100,200,100,30);
		panel.add(desiglabel);
		
		desigTF=new JTextField();
		desigTF.setBounds(220,200,100,30);
		panel.add(desigTF);
		
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
			if(!didTF.getText().equals("") || !didTF.getText().equals(null))
			{
				Doctor d= dr.searchDoctor(didTF.getText()) ;
				
				if(d!=null)
				{
					nameTF.setText(d.getname());
					feeTF.setText(d.getfee()+"");
					desigTF.setText(d.getdesignation());
					
					didTF.setEnabled(false);
					nameTF.setEnabled(true);
					feeTF.setEnabled(true);
					desigTF.setEnabled(true);
					
					loadbtn.setEnabled(true);
					updatebtn.setEnabled(true);
					insertbtn.setEnabled(true);
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
			Doctor d=new Doctor();
			User u1=new User();
			Random rd=new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			d.setdid(didTF.getText());
			d.setname(nameTF.getText());
			d.setfee(Double.parseDouble(feeTF.getText()));
			d.setdesignation(desigTF.getText());
			
			u1.setuid(didTF.getText());
			u1.setpassword(x+"");
			
			if(((desigTF.getText()).equals("Arthopedic")))
			{
				u.setstatus(0);
			}
			else
			{
				u.setstatus(1);
			}
			
			dr.insertinDB(d);  
			ur.insertuser(u1);  
			
			
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+didTF.getText()+"and Password: "+x);
			
			didTF.setText("");
			nameTF.setText("");
			desigTF.setText("");
			feeTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		
		else if(command.equals(refreshbtn.getText()))
		{
			didTF.setText("");
			nameTF.setText("");
			desigTF.setText("");
			feeTF.setText("");
			
			didTF.setEnabled(true);
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		else if(command.equals(updatebtn.getText()))
		{
			Doctor d=new Doctor();
			
			d.setdid(didTF.getText());
			d.setname(nameTF.getText());
			d.setfee(Double.parseDouble(feeTF.getText()));
			d.setdesignation(desigTF.getText());
			
			dr.updateinDB(d);  
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			didTF.setText("");
			nameTF.setText("");
			desigTF.setText("");
			feeTF.setText("");
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
			
			didTF.setEnabled(true);
			nameTF.setEnabled(true);
			desigTF.setEnabled(true);
			feeTF.setEnabled(true);
			
		}
		
		else if(command.equals(deletebtn.getText()))
		{
			dr.deletefromDB(didTF.getText());  
			ur.deleteuser(didTF.getText());  
			 
			JOptionPane.showMessageDialog(this,"Deleted");
			
			didTF.setText("");
			nameTF.setText("");
			desigTF.setText("");
			feeTF.setText("");
			
			didTF.setEnabled(true);
			nameTF.setEnabled(true);
			desigTF.setEnabled(true);
			feeTF.setEnabled(true);
			
			loadbtn.setEnabled(true);
			updatebtn.setEnabled(false);
			insertbtn.setEnabled(true);
			refreshbtn.setEnabled(false);
			deletebtn.setEnabled(false);
		}
		else if(command.equals(backbtn.getText()))
		{
			AdminHome ah=new AdminHome(u);
			ah.setVisible(true);
			this.setVisible(false);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}