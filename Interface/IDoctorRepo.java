package Interface;

import java.lang.*;

import Entity.*;

public interface IDoctorRepo
{
	public void insertinDB(Doctor d);
	public void deletefromDB(String did);
	public void updateinDB(Doctor d);
	public Doctor searchDoctor(String did);
}