package BLL;

import java.sql.ResultSet;
import java.util.Vector;

import DAL.Search;
import DAL.Delete;
import DAL.Insert;
import DAL.Updata;
import MODEL.SetorModel;

import UI.SectorManage;

public class Sector 
{
	public static Vector sector(String cmd,SetorModel setorModel ) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector<>();
		vector=search.search("sector","","", 2);
		if(cmd.equals("search"))
		{
			vector=search.search("sector","sectorid",setorModel.getId(), 2);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("sector", "sectorid", setorModel.getId());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("sector", "'"+setorModel.getId()+"','"+setorModel.getName()+"'");		
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("sector","sectorname","sectorid","'"+setorModel.getName()+"'","'"+setorModel.getId()+"'");
		}
		return vector;
	}
}
