package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.RowDataCursor;


import MODEL.UserModel;
public class UserDAO
{
	public UserModel searchuser(UserModel user)
	{
		Connection connection=DatabaseLink.link();
		UserModel returnuser=null;
		String sql="select * from login where username=? and password=?";
		try
		{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next())
			{
				returnuser=user;
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			DatabaseLink.managelink(connection);
		}
		return returnuser;
	}

}
