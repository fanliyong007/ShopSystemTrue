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
			//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
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
