package it.unipv.ingsw.gi.users;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;

public interface Manage {
	
	public void returnbook(PrendeInPrestito prendeInPrestito , Biblioteca library,Patrono patron) throws Exception;
	public void aggLibro(Libro libro,Biblioteca biblio) throws Exception;
	public void cambiaStato(Patrono pat,Stato state) throws Exception;
	

}
