package BLL;

import java.util.Vector;

import DAL.Delete;
import DAL.Insert;
import DAL.Search;
import DAL.Updata;
import MODEL.DetailOrderModel;

public class  DetailOrder
{
	public Vector  detailorder(String cmd,DetailOrderModel detailOrderModel) 
	{
		Search search=new Search();
		Delete delete=new Delete();
		Insert insert=new Insert();
		Updata updata=new Updata();
		Vector vector=new Vector<>();
		vector=search.search("detailorder","","", 4);
		if(cmd.equals("search"))
		{
			vector=search.search("detailorder","timeid",detailOrderModel.getTimeid(), 4);
		}
		else if (cmd.equals("delete")) 
		{
			delete.delete("detailorder", "timeid", detailOrderModel.getTimeid());
		}
		else if(cmd.equals("insert"))
		{
			insert.insert("detailorder",
						detailOrderModel.getTimeid()	+",'"
						+detailOrderModel.getShopid()+"','"
						+detailOrderModel.getOrderid()+"',"
						+detailOrderModel.getShopprice());
		}
		else if(cmd.equals("updata"))
		{
			updata.updata("detailorder","shopid","timeid","'"+detailOrderModel.getShopid()+"'",detailOrderModel.getTimeid());
			updata.updata("detailorder","orderid","timeid","'"+detailOrderModel.getOrderid()+"'",detailOrderModel.getTimeid());
			updata.updata("detailorder","shopprice","timeid",detailOrderModel.getShopprice(),detailOrderModel.getTimeid());
		}
		return vector;
	}

}
