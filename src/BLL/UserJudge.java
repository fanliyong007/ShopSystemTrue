package BLL;

import DAL.UserDAO;

import MODEL.UserModel;

public class UserJudge
{
	public boolean judge(UserModel user) 
	{
		boolean result;
		UserDAO userDAO=new UserDAO();
		UserModel user2=userDAO.searchuser(user);
		if(user2!= null)
		{
			result=true;
		}
		else
		{
			result=false;
		}
		return result;
	}


}
