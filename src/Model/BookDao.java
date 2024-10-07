package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

	String url = "jdbc:mysql://localhost:3306/sharyu",
			user="root",pass="root";
	
	String q;
	Connection con;
	PreparedStatement ps;
	
	public BookDao() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,user,pass);	
	}
	
	public boolean insertBook(Book obj) throws SQLException
	{
		q="insert into Book Value(?,?,?,?)";
		
		ps=con.prepareStatement(q);
		
		ps.setInt(1, obj.getId());
		ps.setString(2, obj.getName());
		ps.setString(3, obj.getAuthor());;
		ps.setDouble(4, obj.getPrice());
		
		int rows =ps.executeUpdate();
		
		if(rows>0)
			return true;
		else
			return false;
	}
	
	public boolean UpdateBook(Book obj) throws SQLException
	{
		q="Update Book set price=?,name=?,author=? where bid=?";
		
		ps=con.prepareStatement(q);
		
		ps.setDouble(1, obj.getPrice());
		ps.setString(2, obj.getName());
		ps.setString(3, obj.getAuthor());
		ps.setInt(4, obj.getId());
		
		int rows= ps.executeUpdate();
		
		if(rows>0)
			return true;
		else
			return false;
	}
	
	public boolean DeleteBook(int id) throws SQLException
	{
		q="Delete from Book where bid=?";
		
		ps=con.prepareStatement(q);
		
		ps.setInt(1, id);
		
		int rows=ps.executeUpdate();
		
		if(rows>0)
			return true;
		else
			return false;
	}
	
	public ResultSet SearchBook(int id) throws SQLException
	{
		q="select * from Book where bid=?";
		
		ps=con.prepareStatement(q);
		
		ps.setInt(1, id);
		
		ResultSet 	rs=ps.executeQuery();
		
		return rs;
	}
}
