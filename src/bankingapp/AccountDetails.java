package bankingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class AccountDetails {

	public void accountDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Your Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Your Email: ");
		String email = sc.nextLine();
		System.out.println("\n");
		
		try {
			Conn con = new Conn();
			Connection conn = con.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE name = ? AND email=?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				System.out.println("Your id is: " + id);
				
				String name2 = rs.getString("name");
				System.out.println("Your Name: " + name2);
				
				String email2 = rs.getString("email");
				System.out.println("Your Email: " + email2);
				
				String mobile = rs.getString("mobile");
				System.out.println("Your Mobile: " + mobile);
				
				float amount = rs.getFloat("amount");
				System.out.println("Your Balance: " + amount);
				System.out.println("\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
