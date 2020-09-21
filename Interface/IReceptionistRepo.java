package Interface;

import java.lang.*;

import Entity.*;

public interface IReceptionistRepo
{
	public void insertinDB(Receptionist r);
	public void deletefromDB(String rid);
	public void updateinDB(Receptionist r);
	public Receptionist searchReceptionist(String rid);

}