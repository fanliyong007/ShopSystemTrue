package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert
{
	public void insert(String table,String goal) 
	{
		Connection connection=DatabaseLink.link();
		String sql=null;
		try 
		{
			sql="INSERT INTO "+table+" VALUES ("+goal+");";
			System.out.println(sql);
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("insert ok");
			//INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert wrong");
		}
		finally 
		{
			DatabaseLink.managelink(connection);
		}
	}

}
