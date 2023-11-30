package it.unipv.ingsw.gi.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;

/**
 * Dao that handles all the action with the database related to the patron
 * @author nassa
 *
 */
public class PatronoDAO implements IPatronoDAO {

	// Singleton connection instance and needed prepared sql statements
	private MyDbaseconnect dbConnect;
	private static final String loansInserstmnt =  "INSERT INTO listprestiti (patronoID,patrono,libro,date,biblioteca,bookID) VALUES (?, ?, ?, ?, ?,?)";
	private static final String bUpdatestmnt ="UPDATE libro SET isAvailable = false WHERE id = ? ";




	public  PatronoDAO() {
		dbConnect = MyDbaseconnect.getInstance();
	}


	// method to borrow book for database
	public void borrowBookDao(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception {

		Connection conn = dbConnect.getConnection();
		Date dat = Date.valueOf(date);
		PreparedStatement insertStmt = conn.prepareStatement(loansInserstmnt);
		insertStmt.setInt(1, patron.userID);
		insertStmt.setString(2, patron.name);
		insertStmt.setString(3, book.title);
		insertStmt.setDate(4, dat);
		insertStmt.setString(5, library.name);
		insertStmt.setInt(6, book.bookID);
		insertStmt.executeUpdate();

		PreparedStatement bUpdateStmnt = conn.prepareStatement(bUpdatestmnt);
		bUpdateStmnt.setInt(1, book.bookID);
		bUpdateStmnt.executeUpdate();
		MyDbaseconnect.closeConnection(conn);


	}






}
