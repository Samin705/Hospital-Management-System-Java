package Entity;
import java.lang.*;

public class User
{
	private String uid;
	private String password;
	private int status;
	
	public User()
	{
		
	}
	public User(String uid,String password,int status)
	{
		this.uid = uid;
		this.password = password;
		this.status = status;
	}
	
	public void setuid(String uid)
	{this.uid = uid;}
	public void setpassword(String password)
	{this.password = password;}
	public void setstatus(int status)
	{this.status = status;}
	
	public String getuid()
	{return uid;}
	public String getpassword()
	{return password;}
	public int getstatus()
	{return status;}
}