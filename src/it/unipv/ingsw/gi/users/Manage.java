package it.unipv.ingsw.gi.users;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;

/**
 * interface to implement in admin 
 * 
 * @author nassa
 *
 */
public interface Manage {
	
	public void returnbook(PrendeInPrestito prendeInPrestito , Biblioteca library,Patrono patron,Admin admin) throws Exception;
	public void aggLibro(Libro libro,Biblioteca biblio) throws Exception;
	public void aggPatrono(Patrono patrono,Biblioteca bib) throws Exception;
	public void cambiaStato(Patrono pat,Stato state) throws Exception;
	public void canLibro(Libro libro,Biblioteca bib) throws Exception;
	public void canPatrono(Patrono patrono,Biblioteca bib) throws Exception;
	

}
