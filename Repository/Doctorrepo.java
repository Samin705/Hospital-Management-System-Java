package Repository;

import java.lang.*;
import Entity.*;
import Interface.*;

public class Doctorrepo implements IDoctorRepo
{
	DatabaseConnection dbc;
	
	public Doctorrepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertinDB(Doctor d)
	{
		String query = "INSERT INTO doctor VALUES ('"+d.getdid()+"','"+d.getname()+"','"+d.getdesignation()+"',"+d.getfee()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletefromDB(String did)
	{
		String query = "DELETE from doctor WHERE did='"+did+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateinDB(Doctor d)
	{
		String query = "UPDATE doctor SET name='"+d.getname()+"', designation = '"+d.getdesignation()+"', fee = "+d.getfee()+" WHERE did='"+d.getdid()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Doctor searchDoctor(String did)
	{
		Doctor d = null;
		String query = "SELECT `name`, `designation`, `fee` FROM `doctor` WHERE `did`='"+did+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				String designation = dbc.result.getString("designation");
				double fee = dbc.result.getDouble("fee");
				
				d = new Doctor();
				d.setdid(did);
				d.setname(name);
				d.setdesignation(designation);
				d.setfee(fee);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return d;
	}
}