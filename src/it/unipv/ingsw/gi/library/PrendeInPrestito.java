package it.unipv.ingsw.gi.library;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.books.Libro;
import java.time.LocalDate;
import it.unipv.ingsw.gi.library.Biblioteca;

public class PrendeInPrestito {

	public Patrono utente;
	public Libro libro;
	public static LocalDate date;
	public Biblioteca biblioteca;
	
	
	
	public PrendeInPrestito(Patrono utente, Libro libro, LocalDate date, Biblioteca biblioteca) {
		super();
		this.utente = utente;
		this.libro = libro;
		this.date = date;
		this.biblioteca = biblioteca;
	}
	
	
	@Override
	public String toString() {
		
		return "user :" + utente + ", libro :"+ libro +", date :"+ date +", biblioteca :"+ biblioteca;
				
	}

	
	public LocalDate getDate() {
		return date;
	}
	

	public Patrono getUtente() {
		return utente;
	}


	private void setUtente(Patrono utente) {
		this.utente = utente;
	}


	public Libro getLibro() {
		return libro;
	}


	
	
	
	
	
	
	
}