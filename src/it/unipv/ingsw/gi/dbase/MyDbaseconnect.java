package it.unipv.ingsw.gi.dbase;

import java.sql.*;

public class MyDbaseconnect {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "ED^ME^69wlpXOK");// Establishing
																														// connection
			System.out.println("Connected With the database successfully");
		} catch (SQLException e) {	
			System.out.println("Error while connecting to the database");
		}
	}

}
