package Entity;
import java.lang.*;

public class Paitent
{
	private String pid;
	private String name;
	private String appointment;
	
	public Paitent()
	{
		
	}
	public Paitent(String pid,String name,String appointment)
	{
		this.pid = pid;
		this.name = name;
		this.appointment = appointment;
	}
	
	public void setpid(String pid)
	{this.pid = pid;}
	public void setname(String name)
	{this.name = name;}
	public void setappointment(String appointment)
	{this.appointment = appointment;}
	
	public String getpid()
	{return pid;}
	public String getname()
	{return name;}
	public String getappointment()
	{return appointment;}
}