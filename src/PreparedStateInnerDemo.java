
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;



public class PreparedStateInnerDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter book id");
		int bid=sc.nextInt();
		
		System.out.println("Enter book name");
		sc.nextLine();
		String nm=sc.nextLine();
		
		System.out.println("Enter author");
		String au=sc.nextLine();
		
		System.out.println("Enter price");
		double p=sc.nextDouble();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/sharyu",
				user="root",pass="root";
		
		Connection con= DriverManager.getConnection(url,user,pass);
		
		String q= "insert into Book values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(q);
		
		ps.setInt(1, bid);
		ps.setString(2, nm);
		ps.setString(3, au);
		ps.setDouble(4, p);
		
		int rows = ps.executeUpdate();
		
		if(rows>0)
			System.out.println("Records Inserted...");
		
		con.close();
		
		

	}

}
