package it.unipv.ingsw.gi.books;

import java.util.ArrayList;

public interface IBook {
	
	// metodi relativi agli aggiornamenti dei libri Book
		 // Aggiunge un libro al database
	    boolean addBook(Book book);
	    
	    // Cancella un libro dal database
	    /*boolean deleteBook(Book book);*/
	    
	    // Restituisce una lista di tutti i libri nel database
	    ArrayList<Book> getAllBooks();
	    
	    // Cerca un libro nel database per nome
	    ArrayList<Book> getBooksByName(String name);
		boolean deleteBook(String isbn);


}
