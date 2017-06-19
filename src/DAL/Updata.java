package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Updata 
{
	public void updata(String table,String column1,String column2,String name,String id) 
	{
		Connection connection=DatabaseLink.link();
		String sql=null;
		sql="UPDATE "+table+" SET "+column1+" = "+name+"  WHERE "+column2+"= "+id;
		System.out.println(sql);
		try 
		{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.executeUpdate();
			//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
			System.out.println("updata ok");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updata wrong");
		}
		finally 
		{
			DatabaseLink.managelink(connection);
		}
	}
}
