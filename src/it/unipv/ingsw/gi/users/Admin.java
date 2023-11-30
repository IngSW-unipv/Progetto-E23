package it.unipv.ingsw.gi.users;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.posti.PrenotaPosti;


public class Admin extends Persona implements Manage ,PropertyChangeListener{

	/**
	 * admin class with correlated method 
	 * 
	 * @param userID
	 * @param userPASS
	 * @param name
	 */
	public Admin(int userID, String userPASS, String name) {
		super(userID, userPASS, name);

	}

	//method to borrow a book 
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
	
	//method to add book 
	@Override
	public void aggLibro(Libro libro,Biblioteca biblio) throws Exception{
		biblio.addBook(libro);
		
		
	}
	
	//method to delete a book 
	@Override
	public void canLibro(Libro libro,Biblioteca bib) throws Exception{
		bib.canBook(libro);
		
		
	}
	
	//method to add patron 
	@Override
	public void aggPatrono(Patrono patrono, Biblioteca bib) throws Exception {
		bib.addPatrono(patrono);
		
		
	}
	
	// method to delete a patron
	@Override
	public void canPatrono(Patrono patrono,Biblioteca bib) throws Exception{
		bib.canPatrono(patrono);
		
	}
	
	// method to modify a patron state 
	@Override
	public void cambiaStato(Patrono pat, Stato state) throws Exception{
		pat.setStato(state);
		
	}
	
	
	/**
	 * return book method 
	 */
	@Override
	public void returnbook(PrendeInPrestito bitem, Biblioteca library,Patrono patron,Admin admin) throws Exception {

		if (patron.borrowedBooks.contains(bitem.libro)) {

			if (LocalDate.now().isBefore(bitem.getDate())) {
				patron.borrowedBooks.remove(bitem.libro);
				bitem.libro.setIsAvailable(true);
				if (bitem.utente.userID == patron.userID) {
					library.listPrestiti.remove(bitem);
				}
				System.out.println("book returned succefully!");
			}
			else {
				patron.setState(Stato.frozen);
				System.out.println("book returned after allowed loan period and patron state renderded frozen , refer to admins for help");
				patron.borrowedBooks.remove(bitem.libro);
				admin.cambiaStato(patron, Stato.frozen);
				bitem.libro.setIsAvailable(true);
				if (bitem.utente.userID == patron.userID) {
					library.listPrestiti.remove(bitem);
				}
			}
		}

		else {
			System.out.println("this book wasn't borrowed by the user");
		}
	}
	
	
	public ArrayList<Patrono> ricercaPat(ArrayList<Patrono> catalogo, Integer id) {
		ArrayList<Patrono> risultati = new ArrayList<>();

		for (Patrono pat : catalogo) {
			if (pat.userID == id) {
				risultati.add(pat);
				System.out.println(risultati);
			}
		}
		return risultati;
	}
	
	
	public ArrayList<PrendeInPrestito> ricerca2(ArrayList<PrendeInPrestito> catalogo, Integer id) {
		ArrayList<PrendeInPrestito> risultati = new ArrayList<>();

		for (PrendeInPrestito prendeinprestito : catalogo) {
			if (prendeinprestito.libro.getBookID() == id) {
				risultati.add(prendeinprestito);
				System.out.println(risultati);
			}
		}
		return risultati;
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


	
	
	
	public void visualizzaPostiDisponibili() {
		PrenotaPosti p = new PrenotaPosti(userID);
		 p.visualizzaPostiDisponibili();
	 }
	 
	 public void cancellaPrenotazione(int numeroPosto) {
		 PrenotaPosti p = new PrenotaPosti(userID);
		 p.cancellaPrenotazione(this, numeroPosto);
		 
	 }


	 //method to implement the observer pattern 
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		String propertyName = evt.getPropertyName();
        String bookName = ((Libro) evt.getSource()).getTitle();
        boolean isAvailable = (boolean) evt.getNewValue();
        System.out.println(name + " received update: " + bookName + "'s " + propertyName + " changed to " + isAvailable);
		
	}
	
	
	
	
	
}