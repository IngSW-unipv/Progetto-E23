package it.unipv.insw.gi.librarian;

import java.util.ArrayList;

import it.unipv.ingsw.gi.user.User;
import it.unipv.ingsw.gi.books.*;

public interface manage {
	
	
	// metodi relativi agli aggiornamenti dei libri User 
	public ArrayList<User> selectAll();
	public ArrayList<User> selectBYNOME(User usInput);
	public boolean insertUser(User U);
	
	
	// metodi relativi agli aggiornamenti dei libri Book
	 // Aggiunge un libro al database
    boolean addBook(Book book);
    
    // Cancella un libro dal database
    boolean deleteBook(Book book);
    
    // Restituisce una lista di tutti i libri nel database
    ArrayList<Book> getAllBooks();
    
    // Cerca un libro nel database per nome
    ArrayList<Book> getBooksByName(String name);
	boolean deleteBook(String isbn);


}
