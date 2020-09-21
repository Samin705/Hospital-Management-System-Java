package Interface;

import java.lang.*;

import Entity.*;

public interface IAdminRepo
{
	
	public void updateinDB(Admin a);
	public Admin searchAdmin(String aid);

}