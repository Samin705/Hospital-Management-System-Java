package Interface;

import java.lang.*;

import Entity.*;

public interface IPatientRepo
{
	public void insertinDB(Paitent p);
	public void deletefromDB(String pid);
	public void updateinDB(Paitent p);
	public Paitent searchPaitent(String pid);

}