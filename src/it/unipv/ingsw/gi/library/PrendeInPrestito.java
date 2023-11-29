package it.unipv.ingsw.gi.library;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.books.Libro;
import java.time.LocalDate;


public class PrendeInPrestito {

	public Patrono utente;
	public Libro libro;
	public LocalDate date;
	public Biblioteca biblioteca;
	
	
	/**
	 * this is a class the defines the concept of borrowing the book
	 * @param utente the patron borrowing
	 * @param libro the book getting borrowed 
	 * @param date the data of the process
	 * @param biblioteca the library from which the book is getting borrowed 
	 */
	public PrendeInPrestito(Patrono utente, Libro libro, LocalDate date, Biblioteca biblioteca) {
		super();
		this.utente = utente;
		this.libro = libro;
		this.date = date;
		this.biblioteca = biblioteca;
	}
	
	//override of the toString method
	@Override
	public String toString() {
		
		return "user :" + utente + ", libro :"+ libro +", date :"+ date +", biblioteca :"+ biblioteca;
				
	}

	
	public LocalDate getDate() {
		return date;
	}
	

	public Patrono getUtente() {
		return this.utente;
	}


	


	public Libro getLibro() {
		return libro;
	}

	public void setUtente(Patrono utente) {
		this.utente = utente;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}


	
	
	
	
	
	
	
}
