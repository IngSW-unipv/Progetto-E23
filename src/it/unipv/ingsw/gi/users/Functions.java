package it.unipv.ingsw.gi.users;

import java.time.LocalDate;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;


public interface Functions {
	
	public void borrowbook(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception;
	
}
