package Repository;

import java.lang.*;
import Entity.*;
import Interface.*;

public class Paitentrepo implements IPatientRepo
{
	DatabaseConnection dbc;
	
	public Paitentrepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertinDB(Paitent p)
	{
		String query = "INSERT INTO paitent VALUES ('"+p.getpid()+"','"+p.getname()+"',"+p.getappointment()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletefromDB(String pid)
	{
		String query = "DELETE from paitent WHERE pid='"+pid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateinDB(Paitent p)
	{
		String query = "UPDATE paitent SET name='"+p.getname()+"',"+p.getappointment()+" WHERE pid='"+p.getpid()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Paitent searchPaitent(String pid)
	{
		Paitent p = null;
		String query = "SELECT `name`, `appointment` FROM `paitent` WHERE `pid`='"+pid+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				String appointment = dbc.result.getString("appointment");
				
				p = new Paitent();
				p.setpid(pid);
				p.setname(name);
				p.setappointment(appointment);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return p;
	}
}