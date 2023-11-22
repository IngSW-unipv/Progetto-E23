package it.unipv.ingsw.gi.users;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;

public abstract class Persona {
	
	public int userID;
	public String userPASS;
	public String name;
	
	
	public Persona(int userID, String userPASS, String name) {
		super();
		this.userID = userID;
		this.userPASS = userPASS;
		this.name = name;
	}
	

	public abstract void borrowbook(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception;
	
	
	
	

}
