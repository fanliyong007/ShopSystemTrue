package BLL;

import java.util.Vector;

import DAL.Delete;
import DAL.Insert;
import DAL.Search;
import DAL.Updata;
import MODEL.ShopModel;

public class Shop 
{
	public Vector shop(String cmd,ShopModel shopModel) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector<>();
		vector=search.search("shop","","", 5);
		if(cmd.equals("search"))
		{
			vector=search.search("shop","shopname",shopModel.getShopname(), 5);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("shop", "shopid", shopModel.getShopid());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("shop", "'"+shopModel.getShopid()+"','"+shopModel.getShopname()+"',"+shopModel.getShopinprice()+","+shopModel.getShopoutprice()+","+shopModel.getShopnum());
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("shop","shopname","shopid","'"+shopModel.getShopname()+"'","'"+shopModel.getShopid()+"'");
			updata.updata("shop","shopinprice","shopid",shopModel.getShopinprice(),"'"+shopModel.getShopid()+"'");
			updata.updata("shop","shopoutprice","shopid",shopModel.getShopoutprice(),"'"+shopModel.getShopid()+"'");
			updata.updata("shop","shopnumber","shopid",shopModel.getShopnum(),"'"+shopModel.getShopid()+"'");
		}
		return vector;
	}

}
