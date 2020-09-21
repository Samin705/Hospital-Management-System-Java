package Repository;

import java.lang.*;

import Entity.*;
import Interface.*;

public class Userrepo implements IUserRepo
{
	DatabaseConnection dbc;
	
	public Userrepo()
	{
		dbc = new DatabaseConnection();
	}
	public User getUser(String userId, String pass)
	{
		User user = null;
		String query = "SELECT userId, password, status FROM Login WHERE userId='"+userId+"' AND password='"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new User();
				user.setuid(dbc.result.getString("userId"));
				user.setpassword(dbc.result.getString("password"));
				user.setstatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	public void insertuser(User u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getuid()+"','"+u.getpassword()+"',"+u.getstatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateuser(User u){}
	public void deleteuser(String uid)
	{
		String query = "DELETE from login  WHERE userId='"+uid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}