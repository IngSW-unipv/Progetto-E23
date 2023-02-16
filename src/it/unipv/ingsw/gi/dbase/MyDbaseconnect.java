package it.unipv.ingsw.gi.dbase;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class MyDbaseconnect {

public static Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "monDieuestmerveilleux33@");
	}
	catch(Exception e) {System.out.println(e);}
	return con;
}

 public static void main(String[] args) {
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "monDieuestmerveilleux33@");// Establishing
																													// connection
		System.out.println("Connected With the database successfully");
	} catch (SQLException e) {	
		System.out.println("Error while connecting to the database");
		
	}
	
}
 }
	

































