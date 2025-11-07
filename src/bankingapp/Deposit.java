package bankingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Deposit {
	
	public void doDepoist() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============= Depsiting ============= \n");
		System.out.print("Enter Your Accound ID:   ");
		int accountID = sc.nextInt();
		
		System.out.print("Enter Amount You want to Deposit:  ");
		int depositAmount = sc.nextInt();
		
		if(depositAmount <= 0) {
			System.out.println("Amount Should be greater than 0! ");
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
				
				PreparedStatement updatePS = conn.prepareStatement("UPDATE account SET amount = amount + ? WHERE id = ?");
				updatePS.setInt(1, depositAmount);
				updatePS.setInt(2, accountID);
				
				int check = updatePS.executeUpdate();
				if(check > 0) {
					System.out.println("\n" + depositAmount + " Successfully Deposited to your Account! ");
					System.out.println("\n");
				}					
			}
			else {
				System.out.println("Account ID " + accountID + " not found! ");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
