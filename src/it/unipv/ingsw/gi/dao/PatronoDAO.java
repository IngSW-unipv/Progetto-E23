package it.unipv.ingsw.gi.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.*;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Patrono;

public class PatronoDAO implements IPatronoDAO {
	
	private MyDbaseconnect dbConnect;
	
	private static final String loansInserstmnt =  "INSERT INTO listprestiti (patronoID,patrono,libro,date,biblioteca,bookID) VALUES (?, ?, ?, ?, ?,?)";
	private static final String bUpdatestmnt ="UPDATE libro SET isAvailable = false WHERE id = ? ";
	
	/*private static final String incStmnt =" UPDATE patrono SET numOfBorrowedBooks = numOfBorrowedBooks + 1  WHERE id = ?";
	private static final String decStmt ="UPDATE patrono SET numOfBorrowedBooks = numOfBorrowedBooks - 1 WHERE id = ?";
	public static final String binsertstmnt = " UPDATE bibfin.patrono SET borrowedbooks = ? WHERE userID = ?  ";
	*/
	
	
	public  PatronoDAO() {
		dbConnect = MyDbaseconnect.getInstance();
	}
	
	
	
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
		
		
		/*PreparedStatement binsertstat = conn.prepareStatement(binsertstmnt);
		PreparedStatement incStatement = conn.prepareStatement(incStmnt);
		incStatement.setInt(1, patron.userID);
		incStatement.executeUpdate();
		
		
		binsertstat.set(1, (Array) patron.borrowedBooks);
		binsertstat.setInt(2, patron.userID);
		binsertstat.executeUpdate();*/
		
	}
	
	
	
	
	

}
