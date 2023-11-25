package it.unipv.ingsw.gi.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibfin", "root", "ED^ME^69wlpXOK");// Establishing
																														// connection
			System.out.println("Connected With the database successfully");
			System.out.println(connection);
		} catch (SQLException e) {	
			System.out.println("Error while connecting to the database");

		}

	}


}
