package it.unipv.insw.gi.librarian;

import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Book;

public interface search {
	
	public String cerca();
	
	public boolean availability();
	 
    // Restituisce una lista di tutti i libri nel database
    ArrayList<Book> getAllBooks();
    
    // Cerca un libro nel database per nome specifico per il suo nome 
    ArrayList<Book> getBooksByName(String name);
	

}
