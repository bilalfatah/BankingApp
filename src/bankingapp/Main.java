package bankingapp;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("\n============== Welcome to Bifa Bank ============== \n");
			System.out.println("Press 1 to create your account at Bifa Bank! ");
			System.out.println("Press 2 to view your account Details at Bifa Bank! "); 
			System.out.println("Press 3 to deposit amount to your account at Bifa Bank! ");
			System.out.println("Press 4 to withdraw amount from your account at Bifa Bank! ");
			System.out.println("Press 0 to close the app! \n");

			System.out.print("Enter Your Choice! ");
			int choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			
			case 1:
				CreateAccount acc = new CreateAccount();
				acc.createAccount();			
				break;
				
			case 2:
				AccountDetails accdt = new AccountDetails();
				accdt.accountDetails();			
				break;
				
			case 3: 
				Deposit deposit = new Deposit();
				deposit.doDepoist();			
				break;
				
			case 4:
				Withdraw withdraw = new Withdraw();
				withdraw.getWihdraw();	
				break;
				
			case 0:
				System.out.print("App Closed! ");
				return;
				
			default:
				System.out.println("Invalid Input! Try again with valid input! ");
				break;
			}
		}		
	}
}