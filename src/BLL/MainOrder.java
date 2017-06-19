package BLL;

import java.util.Vector;

import DAL.Delete;
import DAL.Insert;
import DAL.Search;
import DAL.Updata;
import MODEL.MainOrderModel;

public class MainOrder 
{
	public Vector mainorder(String cmd,MainOrderModel mainorderModel) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector();
		vector=search.search("mainorder","","", 8);
		if(cmd.equals("search"))
		{
			vector=search.search("mainorder","orderid",mainorderModel.getOrderid(),8);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("mainorder", "mainorderid", mainorderModel.getOrderid());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("mainorder", "'"+mainorderModel.getOrderid()+"','"+
									mainorderModel.getOrdernumber()+"',"+
									mainorderModel.getOrderprice()+","+mainorderModel.getPaymoney()+","
									+mainorderModel.getChangemoney()+",'"+mainorderModel.getBuytime()+"','"+
									mainorderModel.getVcode()+"','"+mainorderModel.getSeller()+"'");
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("mainorder","ordernumber","orderid","'"+mainorderModel.getOrdernumber()+"'","'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","orderprice","orderid",mainorderModel.getOrderprice(),"'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","paymoney","orderid",mainorderModel.getPaymoney(),"'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","changemoney","orderid",mainorderModel.getChangemoney(),"'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","buytime","orderid","'"+mainorderModel.getBuytime()+"'","'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","vcode","orderid","'"+mainorderModel.getVcode()+"'","'"+mainorderModel.getOrderid()+"'");
			updata.updata("mainorder","seller","orderid","'"+mainorderModel.getSeller()+"'","'"+mainorderModel.getOrderid()+"'");
		}
		return vector;
	}

}
