package Entity;
import java.lang.*;

public class Receptionist
{
	private String rid;
	private String name;
	private double salary;
	
	public Receptionist()
	{
		
	}
	public Receptionist(String rid,String name,double salary)
	{
		this.rid = rid;
		this.name = name;
		this.salary = salary;
	}
	
	public void setrid(String rid)
	{this.rid = rid;}
	public void setname(String name)
	{this.name = name;}
	public void setsalary(double salary)
	{this.salary = salary;}
	
	public String getrid()
	{return rid;}
	public String getname()
	{return name;}
	public double getsalary()
	{return salary;}
}