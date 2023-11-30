package it.unipv.ingsw.gi.service;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;


/**
 * class for the service layer for the pattern MVC
 * @author nassa
 *
 */
public class BibServices {

	private PatronoDAO patdao;
	private BibDAO bibdao;
	private AdminDAO admdao;

	/** class constructor
	 * 
	 * @param patdao
	 * @param bibdao
	 * @param admdao
	 */
	public BibServices(PatronoDAO patdao,BibDAO bibdao,AdminDAO admdao) {
		super();
		this.patdao = patdao;
		this.bibdao = bibdao;
		this.admdao = admdao;
	}

	/**
	 *  borrow book service method for patron 
	 * @param book the book selected 
	 * @param date the expiration date 
	 * @param patron the patron 
	 * @param library the library 
	 * 
	 */
	public void servPatBorrowBook(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception{
		patron.borrowbook(book, date, patron, library);
		patdao.borrowBookDao(book, date, patron, library);
	}
	
	
	/**
	 *   borrow book service method for admin
	 *   
	 * @param book the book selected 
	 * @param date the expiration date 
	 * @param patron the patron 
	 * @param library the library
	 * @param admin the admin doing the transaction on behalf of the patron 
	 * 
	 */
	public void servAdBorrowBook(Libro book,LocalDate date,Patrono patron,Biblioteca library,Admin admin) throws Exception{
		admin.borrowbook(book, date, patron, library);
		patdao.borrowBookDao(book, date, patron, library);
	}

	/**
	 *  return book service method for admin 
	 *  
	 * @param pb the item getting returned
	 * @param library the library 
	 * @param patron the patron
	 * @param admin the admin doing the transaction
	 * 
	 */
	public void serRisBook(PrendeInPrestito pb, Biblioteca library,Patrono patron,Admin admin) throws Exception{
		if (LocalDate.now().isBefore(pb.getDate())) {
		admin.returnbook(pb, library, patron,admin);
		admdao.returnBookDao(pb.libro, library, patron);
		}else {
			admin.returnbook(pb, library, patron,admin);
			admdao.returnBookDao(pb.libro, library, patron);
			admdao.cambioStatoDAO(patron, Stato.frozen);
		}
		
	}

	
	/**
	 * service method to modify a patron's state 
	 * 
	 * @param patrono the patron mentioned
	 * @param state the new state 
	 * @param admin the admin doing the action
	 *  
	 */
	public void serCambStato(Patrono patrono,Stato state,Admin admin) throws Exception{
		admin.cambiaStato(patrono, state);
		admdao.cambioStatoDAO(patrono, state);
	}
	
	/**
	 * service method to add a book
	 * @param libro the book getting added
	 * @param biblio the library the book is getting added to
	 * @param admin
	 * @throws Exception
	 */
	public void serAggLib(Libro libro,Biblioteca biblio,Admin admin) throws Exception{
		admin.aggLibro(libro, biblio);
		admdao.agguingiLibro(libro,biblio);
	}

	/**
	 * service method to delete a book from the catalog
	 * 
	 * @param libro the book getting deleted 
	 * @param biblioteca the library from which the book is getting deleted 
	 * @param admin the admin doing it
	 * 
	 */
	public void serDelLibro(Libro libro,Biblioteca biblioteca,Admin admin) throws Exception{
		admin.canLibro(libro, biblioteca);
		admdao.cancellaLibro(libro, biblioteca);
	}

	/**
	 * service method to add a patron
	 * @param patrono the patron getting added
	 * @param biblio the library the book is getting added to
	 * @param admin
	 * @throws Exception
	 */
	public void serAggPat(Patrono patrono,Biblioteca biblioteca,Admin admin) throws Exception{
		admin.aggPatrono(patrono, biblioteca);
		admdao.agguingiPatrono(patrono, biblioteca);
	}
	
	/**
	 * service method to delete a patron from the catalog
	 * 
	 * @param patrono the patron getting deleted 
	 * @param biblioteca the library from which the book is getting deleted 
	 * @param admin the admin doing it
	 * 
	 */
	public void serDelPat(Patrono patrono, Biblioteca biblioteca,Admin admin) throws Exception{
		admin.canPatrono(patrono, biblioteca);
		admdao.cancellapatron(patrono, biblioteca);
	}
	
	
	
	//filler methods 
	public void servRecPat(Biblioteca bib) {
		bibdao.recPat(bib);
	}

	public void servRecLib(Biblioteca bib) {
		bibdao.recLib(bib);
	}

	public void serRecAdm(Biblioteca bib) {
		bibdao.recAdm(bib);
	}
	
	public void serRecLis(Biblioteca bib) {
	
		bibdao.recLispres(bib);
	}


}
