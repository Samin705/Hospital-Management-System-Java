package Interface;

import java.lang.*;

import Entity.*;

public interface IUserRepo
{
	User getUser(String userId, String pass);
	public void insertuser(User u);
	public void deleteuser(String uid);
	public void updateuser(User u);

}