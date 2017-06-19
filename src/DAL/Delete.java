package DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Delete 
{
	public void delete(String table,String column,String goal) 
	{
		Connection connection=DatabaseLink.link();
		PreparedStatement ps=null;
		String sql=null;
		try 
		{
			sql="DELETE FROM "+table+" WHERE "+column+"='"+goal+ "'";
			ps=connection.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("delete ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("delete wrong");
		}
		finally 
		{
			DatabaseLink.managelink(connection);
		}
		//DELETE FROM 表名称 WHERE 列名称 = 值
	}

}
