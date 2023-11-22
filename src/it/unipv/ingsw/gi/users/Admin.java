package it.unipv.ingsw.gi.users;
import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.posti.PrenotazionePostoStudio;
import it.unipv.ingsw.gi.service.BibServices;


public class Admin extends Persona implements Manage {

	public Admin(int userID, String userPASS, String name) {
		super(userID, userPASS, name);

	}

	
	@Override
	public void borrowbook(Libro book, LocalDate date, Patrono patron, Biblioteca library) {
		
		
	}
	
	
	@Override
	public void aggLibro(Libro libro,Biblioteca biblio) throws Exception{
		biblio.addBook(libro);
		AdminDAO a = new AdminDAO();
		a.agguingiLibro(libro);
		
	}
	
	
	@Override
	public void returnbook(PrendeInPrestito bitem, Biblioteca library,Patrono patron) throws Exception {

		if (patron.borrowedBooks.contains(bitem.libro)) {

			if (LocalDate.now().isBefore(bitem.getDate())) {
				patron.borrowedBooks.remove(bitem.libro);
				bitem.libro.setIsAvailable(true);
				PatronoDAO p1 = new PatronoDAO();
				BibDAO bd = new BibDAO();
				AdminDAO ad = new AdminDAO();
				BibServices bs = new BibServices(p1, bd,ad);
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
				PatronoDAO p1 = new PatronoDAO();
				BibDAO bd = new BibDAO();
				AdminDAO ad = new AdminDAO();
				BibServices bs = new BibServices(p1, bd,ad);
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
		PrenotazionePostoStudio p = new PrenotazionePostoStudio(userID);
		 p.visualizzaPostiDisponibili();
	 }
	 
	 public void cancellaPrenotazione(int numeroPosto) {
		 PrenotazionePostoStudio p = new PrenotazionePostoStudio(userID);
		 p.cancellaPrenotazione(this, numeroPosto);
		 
	 }
	
	
	
	
	
	

}