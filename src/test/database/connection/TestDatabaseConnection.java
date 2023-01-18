package test.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {
	
	public static void main(String[] args) {
		
		String name = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Trying to connect to Database");
			System.out.println();
			
			@SuppressWarnings("unused")
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/hibernate-02-one-to-many?useSSL=false&amp",
							name,
							password);
			
			System.out.println("\nSuccessfully connected to Database");
		} catch (SQLException e) {
			System.out.println("Failed to connect to Database");
			e.printStackTrace();
		}
		
	}
	
}
