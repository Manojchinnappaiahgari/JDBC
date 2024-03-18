package manu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String pass = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,pass);
			Statement statement = con.createStatement();
			String query=" ";
			statement.execute(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
