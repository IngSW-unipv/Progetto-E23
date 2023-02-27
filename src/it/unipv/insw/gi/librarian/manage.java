package it.unipv.insw.gi.librarian;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unipv.ingsw.gi.user.User;
import it.unipv.ingsw.gi.account.Account;
import it.unipv.ingsw.gi.books.*;

public interface manage {
	
	
	// metodi relativi agli aggiornamenti degli  User 
	
	public ArrayList<User> selectAll();
	
	public ArrayList<User> selectBYNOME(User usInput);
	
	public boolean insertUser(User U);
	
	
	
	
	
	// metodi relativi agli aggiornamenti dei libri Book
	
	 // Aggiunge un libro al database
    boolean addBook(Book book);
    
    // Restituisce una lista di tutti i libri nel database
    ArrayList<Book> getAllBooks();
    
    // Cerca un libro nel database per nome specifico per il suo nome 
    ArrayList<Book> getBooksByName(String name);
    
    // cancellare un livbro dalla data base se n on c vuole piu
	boolean deleteBook(String isbn);
	
	
	
	
	// operazioni di aggiornamento sugli account
	
	// stampa tutti gli account presente nella data base 
	List<Account> selectAll1();
    	
	// aggiunge account nella data base 
	 public default void addAccount(Account account) throws SQLException {};

 // selezionare un account secondo il suo id
		Account selectById(double id);
		
		


}
