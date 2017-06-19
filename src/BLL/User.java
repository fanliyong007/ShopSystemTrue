package BLL;

import java.util.Vector;

import DAL.Delete;
import DAL.Insert;
import DAL.Search;
import DAL.Updata;
import MODEL.UserModel;

public class User 
{
	public Vector user(String cmd,UserModel userModel) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector<>();
		vector=search.search("login","","", 2);
		if(cmd.equals("search"))
		{
			vector=search.search("login","username",userModel.getUsername(), 2);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("login", "username", userModel.getUsername());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("login", "'"+userModel.getUsername()+"','"+userModel.getPassword()+"'");		
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("login","password","username","'"+userModel.getPassword()+"'","'"+userModel.getUsername()+"'");
		}
		return vector;
	}

}
