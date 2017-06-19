package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Search 
{
	
	public  Vector search(String table,String column,String goal,int num)
	{
		Connection connection=DatabaseLink.link();
		Vector vector=new Vector();
		String sql=null;
		if(goal=="")
			sql="select*from "+table+" ;";
		else 		
			sql="select*from "+table+" where "+column+" like '%"+goal+"%';";
		try 
		{
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet resultSet=ps.executeQuery();
			while (resultSet.next())
			{
				for(int i=1;i<=num;i++)
				{
					vector.add(resultSet.getString(i));
				}
			}
			System.out.println("search ok");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("search wrong");
		}
		finally 
		{
			DatabaseLink.managelink(connection);
		}
		return vector;
	}

}
