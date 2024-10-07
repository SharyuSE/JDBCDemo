import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CollableDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/sharyu",
				user="root", pass="root";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		
		CallableStatement cs=con.prepareCall("{call delBook(?)}");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter id");
		int id=sc.nextInt();
		
		
		cs.setInt(1, id);
		
		int rows = cs.executeUpdate();
		
		if(rows > 0)
			System.out.println("Record Deleted....");
		else
			System.out.println("Record Not FOUND.....");
		
		con.close();
	}

}
