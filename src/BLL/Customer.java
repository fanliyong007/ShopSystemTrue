package BLL;

import java.util.Vector;

import DAL.Delete;
import DAL.Insert;
import DAL.Search;
import DAL.Updata;
import MODEL.CustomerModel;

public class Customer 
{
	public Vector customer(String cmd,CustomerModel cModel) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector<>();
		vector=search.search("customer","","", 3);
		if(cmd.equals("search"))
		{
			vector=search.search("customer","customerid",cModel.getId(), 3);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("customer", "customerid", cModel.getId());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("customer", "'"+cModel.getId()+"','"+cModel.getName()+"','"+cModel.getCode()+"'");		
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("customer","customername","customerid","'"+cModel.getName()+"'","'"+cModel.getId()+"'");
		}
		return vector;
	}

}
