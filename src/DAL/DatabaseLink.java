package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseLink
{
	public static Connection link()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://119.28.59.127:3306/shopsystem", "admin", "fanliyong8880+");
			System.out.println("link ok");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void managelink(Connection connection)
	{
		if(connection!=null)
		{
			try
			{
				connection.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
