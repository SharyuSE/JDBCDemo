import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllRecords {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 String url = "jdbc:mysql://localhost:3306/sharyu",
					user="root",pass="root";
		 
		 Connection con=DriverManager.getConnection(url,user,pass);
		 
		 String q="Select * from Book";
		 
		 PreparedStatement ps=con.prepareStatement(q);
		 
		 ResultSet rs=ps.executeQuery();
		 
		 System.out.println("All records are ..");
		 
		 while(rs.next())
			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
		 
		 con.close();

	}

}
