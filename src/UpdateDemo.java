import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter book id which is updated ");
		int bid=sc.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/sharyu",
				user="root",pass="root";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		
		String q="Update Book set p = ?"+"where bid=?";
		
		PreparedStatement ps=con.prepareStatement(q);
		
		ps.setInt(1, bid);
		
		int rows =ps.executeUpdate();
		
		if(rows>0)
			System.out.println("record updated...");
		
		con.close();
		
		
		

	}

}
