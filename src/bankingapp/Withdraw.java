package bankingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Withdraw {
	public void getWihdraw() {
	
		Scanner sc = new Scanner(System.in);

		System.out.println("============= Withdrawing ============= \n");
		System.out.print("Enter Your Account ID: ");
		int accountID = sc.nextInt();
		
		System.out.print("Enter amount you want Withdraw: ");
		int withdrawAmount = sc.nextInt();
		
		if(withdrawAmount <= 0) {
			System.out.println("Invalid! Amount Should be greater than " + withdrawAmount + " !");
			return;
		}
		
		try {
			Conn con = new Conn();
			Connection conn = con.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT amount FROM account WHERE id = ?");
			ps.setInt(1, accountID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int currentAmount = rs.getInt("amount");
				
				if(currentAmount < withdrawAmount) {
					System.out.println("Insufficient Balance! ");
					return;
				}

				PreparedStatement updatePS = conn.prepareStatement("UPDATE account SET amount = amount - ? WHERE id = ?");
				updatePS.setInt(1, withdrawAmount);
				updatePS.setInt(2, accountID);
				
				int check = updatePS.executeUpdate();
				if(check > 0) {
					System.out.println("Withdrawal of " + withdrawAmount + " Amount Successful!");
					System.out.println("\n");
				}	
			}
			else {
				System.out.println("Account ID " + accountID + "not found! ");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
