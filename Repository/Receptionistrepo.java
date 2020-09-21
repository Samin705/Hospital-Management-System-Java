package Repository;

import java.lang.*;
import Entity.*;
import Interface.*;

public class Receptionistrepo implements IReceptionistRepo
{
	DatabaseConnection dbc;
	
	public Receptionistrepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertinDB(Receptionist r)
	{
		String query = "INSERT INTO receptionist VALUES ('"+r.getrid()+"','"+r.getname()+"',"+r.getsalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletefromDB(String rid)
	{
		String query = "DELETE from receptionist WHERE rid='"+rid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateinDB(Receptionist r)
	{
		String query = "UPDATE receptionist SET name='"+r.getname()+"', salary="+r.getsalary()+" WHERE rid='"+r.getrid()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Receptionist searchReceptionist(String rid)
	{
		Receptionist r = null;
		String query = "SELECT `name`, `salary` FROM `receptionist` WHERE `rid`='"+rid+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				double salary = dbc.result.getDouble("salary");
				
				r = new Receptionist();
				r.setrid(rid);
				r.setname(name);
				r.setsalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return r;
	}
}