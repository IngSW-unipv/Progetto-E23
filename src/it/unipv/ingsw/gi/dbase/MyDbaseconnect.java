package it.unipv.ingsw.gi.dbase;



import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;




public class MyDbaseconnect {
	
	private static final String PROPERTYDBDRIVER = "DBDRIVER";
	private static final String PROPERTYDBURL = "DBURL";
	private static final String PROPERTYNAME = "db_usn"; 
	private static final String PROPERTYPSW = "db_psw"; 
	private static String username;
	private static String password;
	private static String dbDriver;
	private static String dbURL;
	private static MyDbaseconnect instance;
	
	
	private MyDbaseconnect() {
		init();
	}
	
	
	private static void init() {
		Properties p = new Properties(System.getProperties());
		try {
			p.load(new FileInputStream("properties/properties"));
			username=p.getProperty(PROPERTYNAME);
			password=p.getProperty(PROPERTYPSW);
			dbDriver =p.getProperty(PROPERTYDBDRIVER);
			dbURL =p.getProperty(PROPERTYDBURL);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean isOpen(Connection conn)
	{
		if (conn == null)
			return false;
		else
			return true;
	}

	public static Connection closeConnection(Connection conn)
	{
		if ( !isOpen(conn) )
			return null;
		try 
		{

			conn.close();
			conn = null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	
	public static Connection startConnection(Connection conn, String schema)
	{
		init();
		System.out.println(dbURL);
	
		
		
		if ( isOpen(conn) )
			closeConnection(conn);
	
		try 
		{
			
			dbURL=String.format(dbURL,schema); 
			System.out.println(dbURL);
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbURL, username, password);// Apertura connessione

		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibfin", "root", "ED^ME^69wlpXOK");
		}
		catch(Exception e) {System.out.println(e);}
		return con;
	}
	
	public static MyDbaseconnect getInstance() {
		

		if (instance == null ) {
			instance = new MyDbaseconnect();
		}
		return instance;
	}

	
	
	
 

	
 public static void main(String[] args) {
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibfin", "root", "ED^ME^69wlpXOK");// Establishing
																													// connection
		System.out.println("Connected With the database successfully");
	} catch (SQLException e) {	
		System.out.println("Error while connecting to the database");

	}

}

	
 
 
 

}

