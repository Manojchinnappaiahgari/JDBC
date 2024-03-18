package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args){
		
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String pass="root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			System.out.println("Successs");
			
			Connection con = DriverManager.getConnection(url,username,pass);
			
//			 Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			 
			 String query=" delete from student where name = 'Manoj' ";
			 
//      		 System.out.println(statement.executeUpdate(query));
			 
			 
			 
			
//			String query="insert into student(`id`,`name`,`phone`) values (?,?,?)";
			
			PreparedStatement pstatement = con.prepareStatement(query);
			 pstatement.executeUpdate();
			
/*			Scanner sc	=new Scanner(System.in);
			
			System.out.println("Enter the number of rows to be inserted");
			int n=sc.nextInt();
			
			con.setAutoCommit(false);
			
			for(int i=1;i<=n;i++) {
				int id= sc.nextInt();
				String name=sc.next();
				String phone=sc.next();
				pstatement.setInt(1, id);
				pstatement.setString(2, name);
				pstatement.setString(3, phone);
				pstatement.execute();
				
			}
			
			con.commit();
			System.out.println("succesfully executed");           */
			
			
			
/*		    Scanner sc	=new Scanner(System.in);
		    
		    System.out.println("Enter the id");
		    
		    int id= sc.nextInt();
		    
		    System.out.println("Enter name");
		    
		    String name=sc.next();
		    
		    System.out.println("Enter the number");
		    
		    String phone=sc.next();
		    
		    pstatement.setInt(1, id);
		    pstatement.setString(2, name);
		    pstatement.setString(3, phone);
		    
		    pstatement.execute();
		    
		    System.out.println("Statement executed succesfully");    */
		    
/*			 String Query= "insert into student (`id`,`name`,`phone`) values(1,'Manoj', '6300279353') ";
			 
			 String Query2= "insert into student (`id`,`name`,`phone`) values(10,'Manoj', '6300279353') ";
			 String Query3= "insert into student (`id`,`name`,`phone`) values(11,'Dhoni', '9392870211') ";
			 String Query4= "insert into student (`id`,`name`,`phone`) values(13,'raina', '9701147567') ";
			 
			 statement.addBatch(Query2);
			 statement.addBatch(Query3);
			 statement.addBatch(Query4);
			 	 
			 statement.executeBatch();                 */
			 
//			  ResultSet res = statement.executeQuery(Query);
			  
/*   This can be done when we know about the database
  			  System.out.println("id"+" "+"age"+" "+" email"+" "+"name");
			 while(res.next()==true) {
			  System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			 }
			 
			 res.first();
			 System.out.println("-------------------");
			 System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			 
			 res.absolute(2);
			 System.out.println("-----------------------");
			 
			 System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));   */
			 
//     these following lines of code shows how to get metadata of a unknown table			 
			  
/*		ResultSetMetaData data = res.getMetaData();
		int count = data.getColumnCount();
		
//		System.out.println(data.getColumnName(1)+" "+data.getColumnName(2)+" "+data.getColumnName(3)+" "+data.getColumnName(4)+" "+data.getColumnName(5));
			  
		for(int i=1;i<=count;i++) {
			
			System.out.println(data.getColumnName(i)+"--> dtatype is --->"+data.getColumnTypeName(i));
			
		}
		res.absolute(2);
		
		System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5));
		
		res.close();
		statement.close();
		con.close();   */
		
		
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
