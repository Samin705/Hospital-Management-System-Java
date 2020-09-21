package Repository;

import java.lang.*;
import Entity.*;
import Interface.*;

public class Adminrepo implements IAdminRepo
{
	DatabaseConnection dbc;
	
	public Adminrepo()
	{
		dbc = new DatabaseConnection();
	}
	
	/*public void insertinDB(Admin a)
	{
		String query = "INSERT INTO admin VALUES ('"+a.getaid()+"','"+a.getname()+"',"+a.getsalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletefromDB(String aid)
	{
		String query = "DELETE from admin WHERE aid='"+aid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}*/
	public void updateinDB(Admin a)
	{
		String query = "UPDATE admin SET name='"+a.getname()+"', salary = "+a.getsalary()+" WHERE aid='"+a.getaid()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Admin searchAdmin(String aid)
	{
		Admin a = null;
		String query = "SELECT `name`, `salary` FROM `admin` WHERE `aid`='"+aid+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				double salary = dbc.result.getDouble("salary");
				
				a = new Admin();
				a.setaid(aid);
				a.setname(name);
				a.setsalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return a;
	}
}