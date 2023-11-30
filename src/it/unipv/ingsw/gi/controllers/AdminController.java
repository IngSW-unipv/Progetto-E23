package it.unipv.ingsw.gi.controllers;

import java.time.LocalDate;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

/**
 * controller for the admin related tasks 
 * @author nassa
 *
 */
public class AdminController {
	
	PatronoDAO p1 = new PatronoDAO();
	BibDAO bd = new BibDAO();
	AdminDAO ad = new AdminDAO();
	BibServices bs = new BibServices(p1, bd,ad);
	Admin admin;

	public AdminController(Admin admin) {
		super();
		this.admin = admin;
	}
	
	
	/**method to pass the input from the borrow book view to the service layer 
	 * 
	 * @param book book selected in the view 
	 * @param date current date 
	 * @param patron patron passed on from the view
	 * @param library library passed on from the view
	 * @param admin admin passed on from the view 
	 */
	public void borrowButtonClick(Libro book,LocalDate date,Patrono patron,Biblioteca library,Admin admin) {
		try {
			bs.servAdBorrowBook(book, date, patron, library,admin);			
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	/**
	 * method to pass the input from the return book view to the service layer
	 * 
	 * @param bitem the borrowed item selected in the view 
	 * @param library the library passed on from the view 
	 * @param patron the patron passed on from the view 
	 * @param admin the admin passed on from the view
	 */
	public void returnButtonClick(PrendeInPrestito bitem, Biblioteca library,Patrono patron,Admin admin) {
		try {
			bs.serRisBook(bitem, library, patron, admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to pass the input from the state modification view to the service layer
	 * @param pat the selected patron from the view 
	 * @param state the new patron state selected from the view
	 * @param adminn the admin doing the action passed on from the view 
	 */
	public void cambiaStatoButtonClick(Patrono pat, Stato state,Admin adminn) {
		try {
			bs.serCambStato(pat, state,adminn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 *  method to pass the input from the add book view to the service layer
	 * @param libro the book getting added passed on from the view
	 * @param biblio the library 
	 * @param adminn the admin doing the action passed from the view 
	 */
	public void addbookButtonClick(Libro libro,Biblioteca biblio,Admin adminn) {
		try {
			bs.serAggLib(libro, biblio,adminn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**  method to pass the input from the cancel book view to the service layer
	 * 
	 * @param libro the book getting deleted selected in the view
	 * @param bib the library 
	 * @param adminn the admin doing the action 
	 */
	public void canbookButtonClick(Libro libro,Biblioteca bib,Admin adminn) {
		try {
			bs.serDelLibro(libro, bib,adminn);	
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	
	/**
	 *  method to pass the input from the add patron view to the service layer
	 * @param patrono the patron getting added passed on from the view
	 * @param biblio the library 
	 * @param adminn the admin doing the action passed from the view 
	 */
	public void addPatronoButtonClick(Patrono patrono, Biblioteca bib,Admin adminn) {
		try {
			bs.serAggPat(patrono, bib,adminn);			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	/**
	 *  method to pass the input from the delete patron view to the service layer
	 * @param patrono the patron getting deleted selected from the view
	 * @param biblio the library 
	 * @param adminn the admin doing the action passed from the view 
	 */
	public void canPatronoButtonClick(Patrono patrono, Biblioteca bib,Admin adminn){
		try {
			bs.serDelPat(patrono, bib,adminn);	
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	

}
