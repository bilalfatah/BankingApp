package bankingapp;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conn {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankapp","root","bitterLikeDeath");
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
