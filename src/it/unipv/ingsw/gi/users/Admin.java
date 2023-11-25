package it.unipv.ingsw.gi.users;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.service.BibServices;


public class Admin extends Persona implements Manage ,PropertyChangeListener{

	PatronoDAO p1 = new PatronoDAO();
	BibDAO bd = new BibDAO();
	AdminDAO ad = new AdminDAO();
	BibServices bs = new BibServices(p1, bd,ad);
	
	public Admin(int userID, String userPASS, String name) {
		super(userID, userPASS, name);

	}

	
	@Override
	public void borrowbook(Libro book, LocalDate date, Patrono patron, Biblioteca library) throws Exception{
		if (book.isAvailable == true) {
			if (patron.state == Stato.active) {
				if (patron.borrowedBooks.size() < 5) {
					date = LocalDate.now().plus(30, ChronoUnit.DAYS);
					patron.borrowedBooks.add(book);
					PrendeInPrestito borrowedItem = new PrendeInPrestito(patron,book,date,library);
					library.listPrestiti.add(borrowedItem);
					book.setIsAvailable(false);
					PatronoDAO pd = new PatronoDAO();
					BibDAO pr = new BibDAO();
					AdminDAO ad = new AdminDAO();
					BibServices bs = new BibServices(pd,pr,ad);
					bs.servBorrowBook(book, date, patron, library);
					System.out.println("book borrowed succefully");
					System.out.println(library.listPrestiti);
					System.out.println(patron.borrowedBooks);
					
				}
				else {
					System.out.println("max number of books allowed already reached please return some books before trying again");
					
				}}
			else {
				System.out.println("account state not active refear to the admin for help");
				
			}}
		else {

			System.out.println("book is not available");
		}
		
	}
	
	
	@Override
	public void aggLibro(Libro libro,Biblioteca biblio) throws Exception{
		biblio.addBook(libro);
		bs.serAggLib(libro, biblio);
		
	}
	
	@Override
	public void canLibro(Libro libro,Biblioteca bib) throws Exception{
		bib.canBook(libro);
		bs.serDelLibro(libro, bib);
		
	}
	
	
	@Override
	public void aggPatrono(Patrono patrono, Biblioteca bib) throws Exception {
		bib.addPatrono(patrono);
		bs.serAggPat(patrono, bib);
		
	}
	
	@Override
	public void canPatrono(Patrono patrono,Biblioteca bib) throws Exception{
		bib.canPat(patrono);
		bs.serDelPat(patrono, bib);
	}
	
	
	
	@Override
	public void returnbook(PrendeInPrestito bitem, Biblioteca library,Patrono patron) throws Exception {

		if (patron.borrowedBooks.contains(bitem.libro)) {

			if (LocalDate.now().isBefore(bitem.getDate())) {
				patron.borrowedBooks.remove(bitem.libro);
				bitem.libro.setIsAvailable(true);
				bs.serRisBook(bitem.libro, library, patron);
				bitem.libro.setIsAvailable(true);
				PrendeInPrestito borrowedItem = new PrendeInPrestito(patron,bitem.libro, null, library);
				library.listPrestiti.remove(borrowedItem);
				System.out.println("book returned succefully!");
			}
			else {
				
				patron.setState(Stato.frozen);
				System.out.println("book returned after allowed loan period and patron state renderded frozen , refer to admins for help");
				patron.borrowedBooks.remove(bitem.libro);
				bitem.libro.setIsAvailable(true);
				ad.cambioStatoDAO(patron, Stato.frozen);
				bs.serRisBook(bitem.libro, library, patron);
				bitem.libro.setIsAvailable(true);
				PrendeInPrestito borrowedItem = new PrendeInPrestito(patron, bitem.libro, null, library);
				library.listPrestiti.remove(borrowedItem);
			}
		}

		else {

			System.out.println("this book wasn't borrowed by the user");
		}
	}
	
	
	
	
	public int getAdminID() {
		return userID;
	}
	
	public String getAdminName() {
		return this.name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdminnPASS(String patronPASS) {
		this.userPASS = patronPASS;
	}
	
	
	
	public void setAdminID(int patronID) {
		this.userID = patronID;
	}
	
	
	@Override
	public String toString() {
		return this.name+ " " + "ID :  " +this.userID;
	}


	@Override
	public void cambiaStato(Patrono pat, Stato state) throws Exception{
		pat.setStato(state);
		PatronoDAO p1 = new PatronoDAO();
		BibDAO bd = new BibDAO();
		AdminDAO ad = new AdminDAO();
		BibServices bs = new BibServices(p1, bd,ad);
		bs.serCambStato(pat, state);
	}
	
	
	public void visualizzaPostiDisponibili() {
		PrenotaPosti p = new PrenotaPosti(userID);
		 p.visualizzaPostiDisponibili();
	 }
	 
	 public void cancellaPrenotazione(int numeroPosto) {
		 PrenotaPosti p = new PrenotaPosti(userID);
		 p.cancellaPrenotazione(this, numeroPosto);
		 
	 }


	


	@Override
	public void tolLibro(Libro libro, Biblioteca bib) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String propertyName = evt.getPropertyName();
        String bookName = ((Libro) evt.getSource()).getTitle();
        boolean isAvailable = (boolean) evt.getNewValue();
        System.out.println(name + " received update: " + bookName + "'s " + propertyName + " changed to " + isAvailable);
		
	}
	
	
	
	
	
}