package jdbc.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String pass = "root";
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Successs");

			Connection con = DriverManager.getConnection(url, username, pass);

			System.out.println(" Welcome to MyBank........");

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the Account Number..");

			int acc_num = sc.nextInt();

			System.out.println("Enter the Pin");

			int pin = sc.nextInt();

			PreparedStatement pst = con.prepareStatement("select * from account where acc_num=? and pin =?");

			pst.setInt(1, acc_num);

			pst.setInt(2, pin);

			ResultSet set = pst.executeQuery();

			set.next();

			String name = set.getString(2);
			int balance = set.getInt(4);

			System.out.println(" Welcome to MyBank.." + name);

			System.out.println(" Your available balance is..." + balance);

//        Transfer Model.....................

			System.out.println("<------------Transfer Details------------------->");

			System.out.println("Enter the Benificiary Account Number");

			int ben_acc = sc.nextInt();

			System.out.println("Enter the Transfer amount");

			int bamount = sc.nextInt();

			PreparedStatement pst1 = con.prepareStatement("update account set balance=balance-? where acc_num=?");

			pst1.setInt(1, bamount);
			pst1.setInt(2, ben_acc);
			pst1.executeUpdate();
			System.out.println("<-----------Incoming Credit Request-------------->");
			System.out.println(name + "Account Number " + acc_num + " Want to Transfer" + bamount);

			System.out.println("Press Y TO Receive the Money");

			System.out.println("Press N to Reject ");

			String choice = sc.next();

			if (choice.equals("y")) {

				PreparedStatement pst2 = con.prepareStatement(" update account set balance = balance+?  where acc_num=?");
				pst2.setInt(1, bamount);
				pst2.setInt(2, ben_acc);
				pst2.executeUpdate();
				PreparedStatement pst3 = con.prepareStatement("select * from account where acc_num=?");

				pst3.setInt(1, ben_acc);
				ResultSet rset = pst3.executeQuery();
				rset.next();

				System.out.println(" Your Updated Balance is =" + rset.getInt(4));

			} else {

				PreparedStatement pst4 = con.prepareStatement("select * from account where acc_num=?");

				pst4.setInt(1, ben_acc);
				ResultSet rset = pst4.executeQuery();
				rset.next();

				System.out.println(" Your Existing Balance is =" + rset.getInt(4));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
