package Entity;
import java.lang.*;

public class Doctor
{
	private String did;
	private String name;
	private String designation;
	private double fee;
	
	public Doctor()
	{
		
	}
	public Doctor(String did,String name,String designation,double fee)
	{
		this.did = did;
		this.name = name;
		this.designation = designation;
		this.fee = fee;
	}
	 
	public void setdid(String did)
	{this.did = did;}
	public void setname(String name)
	{this.name = name;}
	public void setdesignation(String designation)
	{this.designation = designation;}
	public void setfee(double fee)
	{this.fee = fee;}
	
	public String getdid()
	{return did;}
	public String getname()
	{return name;}
	public String getdesignation()
	{return designation;}
	public double getfee()
	{return fee;}
}