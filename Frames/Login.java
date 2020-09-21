package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class Login extends JFrame implements ActionListener, MouseListener
{
	JLabel title,userLabel,passLabel,backImgLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn,exitBtn,showPassBtn;
	ImageIcon backImg;
	JPanel panel;
	Color color,color1;
	
	
	public Login()
	{
		super("HOSPITAL MANAGEMENT SYSTEM");
		
		this.setSize(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		color = new Color(26,150,35);
		color1= new Color(247,9,190);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(color);

		
		title = new JLabel("Login Window");
		title.setBounds(190,80,500,132);
		title.setFont(new Font("Goudy Stout",Font.BOLD,30));
		title.setForeground(color1);
		panel.add(title);
		
		userLabel = new JLabel("User Name : ");
		userLabel.setBounds(215,145,425,132);
		userLabel.setFont(new Font("Arial Black",Font.BOLD,25));
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(410,200,200,30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(234,200,425,132);
		passLabel.setFont(new Font("Arial Black",Font.BOLD,25));
		panel.add(passLabel);
			
		passPF = new JPasswordField();
		passPF.setBounds(410,255,200,30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(590,320,130,30);
		showPassBtn.setFont(new Font("Arial Black",Font.BOLD,20));
		showPassBtn.setBackground(color);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(250,320,150,30);
		loginBtn.setFont(new Font("Arial Black",Font.BOLD,23));
		loginBtn.setBackground(color);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(430,320,150,30);
		exitBtn.setFont(new Font("Arial Black",Font.BOLD,23));
		exitBtn.setBackground(Color.RED);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		
		backImg = new ImageIcon("hosplogo1.jpg");
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
		
		if(command.equals(loginBtn.getText()))
		{
			Userrepo ur = new Userrepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getstatus() == 0 || user.getstatus() == 1)
				{
					DoctorHome dh=new DoctorHome(user);
					dh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getstatus() == 2 || user.getstatus() == 3)
				{
					ReceptionistHome rh=new ReceptionistHome(user);
					rh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getstatus() == 4)
				{
					AdminHome ah=new AdminHome(user);
					ah.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	
	
	
}