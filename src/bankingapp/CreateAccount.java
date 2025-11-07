package bankingapp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class CreateAccount {
	public void createAccount() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============= Creating Account ============= \n");
		System.out.print("Enter Your Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Your Email: ");
		String email = sc.nextLine();
		System.out.print("Enter Your Mobile Number: ");
		String mob = sc.nextLine();
		System.out.print("Enter Amount to Deposit: ");
		float amount = sc.nextFloat();

		System.out.println("\n");
		
		try {
			Conn con = new Conn();
			Connection conn = con.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO account (name, email, mobile, amount) VALUES (?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mob);
			ps.setFloat(4, amount);

			int details = ps.executeUpdate();
		
			if(details > 0) {
				System.out.println("Mr. " + name + " Welcome to Bifa Bank \nYour Current Balance is " + amount);
				System.out.println("\n");
			}
			else {
				System.out.println("Failed to create account! ");
			}
		}
		catch(SQLException e) {
			if (e.getSQLState().startsWith("23")) { 
                System.out.println("Failed: A user with this email already exists! ");
            }
			else {
				System.out.println("A database error occurred during account creation! ");
                e.printStackTrace();
			}
		}
	}
}
