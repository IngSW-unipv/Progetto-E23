package it.unipv.ingsw.gi.controllers;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.users.Patrono;

/** controller for the patron related tasks
 * 
 * @author nassa
 *
 */
public class PatronoController {

	Patrono patrono;
	PatronoDAO pd = new PatronoDAO();
	BibDAO pr = new BibDAO();
	AdminDAO ad = new AdminDAO();
	BibServices bs = new BibServices(pd,pr,ad);
	
	public PatronoController(Patrono patrono) {
		this.patrono = patrono;
	}


	/**
	 * controller method to call the service layer method for borrow book function for a patron 
	 * @param book the book selected from the view 
	 * @param date current date 
	 * @param patron the patron doing the action  
	 * @param library the library borrowing from 
	 */
	public void borrowButtonClick(Libro book,LocalDate date,Patrono patron,Biblioteca library) {
		try {
			
			bs.servPatBorrowBook(book, date, patron, library);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
