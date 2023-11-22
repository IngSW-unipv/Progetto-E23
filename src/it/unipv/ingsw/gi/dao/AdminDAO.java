package it.unipv.ingsw.gi.dao;
import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class AdminDAO implements IAdminDAO{


	private MyDbaseconnect dbConnect;
	public static final String bookInsrtStmnt= "INSERT INTO libro (id, title, author, isAvailable, language, prezzo) VALUES (?, ?, ?, ?, ?, ?) ";
	private static final String loandeleteStmt = "DELETE FROM listprestiti WHERE bookID = ?";
	private static final String bUpdatestmnt2 ="UPDATE libro SET isAvailable = true WHERE id = ? ";
	private static final String uUpdayestmnt="UPDATE patrono SET stato = ? WHERE id = ?";

	public AdminDAO() {
		dbConnect = MyDbaseconnect.getInstance();
	}





	@Override
	public void agguingiLibro(Libro libro) throws Exception {

		Connection conn = dbConnect.getConnection();
		PreparedStatement aggLibro = conn.prepareStatement(bookInsrtStmnt);
		aggLibro.setInt(1, libro.bookID);
		aggLibro.setString(2, libro.title);
		aggLibro.setString(3, libro.author);
		aggLibro.setBoolean(4, libro.isAvailable);
		Lang lang= libro.language;
		aggLibro.setString(5, lang.name());
		aggLibro.setDouble(6, libro.prezzo);
		aggLibro.executeUpdate();


	}

	
	
	public void returnBookDao(Libro libro , Biblioteca library,Patrono patron) throws Exception{

		Connection conn = dbConnect.getConnection();
		PreparedStatement dltstmt = conn.prepareStatement(loandeleteStmt);
		dltstmt.setInt(1, libro.getBookID());
		dltstmt.executeUpdate();
		PreparedStatement bUpdateStmnt = conn.prepareStatement(bUpdatestmnt2);
		bUpdateStmnt.setInt(1, libro.getBookID());
		bUpdateStmnt.executeUpdate();



		/*	PreparedStatement decStatement = conn.prepareStatement(decStmt);
		decStatement.setInt(1, patron.userID);
		decStatement.executeUpdate();
		 */

	}
	
	
	
	
	public void cambioStatoDAO(Patrono patron,Stato state) throws Exception{
		Connection conn = dbConnect.getConnection();
		PreparedStatement uUpStamnt = conn.prepareStatement(uUpdayestmnt);
		uUpStamnt.setString(1, state.name());
		uUpStamnt.setInt(2, patron.userID);
		uUpStamnt.executeUpdate();
		
		
	}

}
