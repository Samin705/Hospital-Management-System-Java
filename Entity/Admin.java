package Entity;

import java.lang.*;

public class Admin
{
	private String aid;
	private String name;
	private double salary;
	
	public Admin()
	{
		
	}
	public Admin(String aid,String name,double salary)
	{
		this.aid = aid;
		this.name = name;
		this.salary = salary;
	}
	
	public void setaid(String aid)
	{this.aid = aid;}
	public void setname(String name)
	{this.name = name;}
	public void setsalary(double salary)
	{this.salary = salary;}
	
	public String getaid()
	{return aid;}
	public String getname()
	{return name;}
	public double getsalary()
	{return salary;}
}