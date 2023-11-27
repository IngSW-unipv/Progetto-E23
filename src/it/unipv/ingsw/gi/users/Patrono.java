package it.unipv.ingsw.gi.users;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import it.unipv.ingsw.gi.library.Acquistare;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;

public class Patrono extends Persona implements Serializable , PropertyChangeListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Libro> borrowedBooks;
	public Stato state;
	public double saldo;
	public ArrayList<Libro> carello;
	private PrenotaPosti prenotaPostoStudio;
	
	

	public Patrono(int userID, String userPASS, String name, ArrayList<Libro> borrowedBooks, 
			Stato state,double saldo) {
		super(userID, userPASS, name);
		this.borrowedBooks = borrowedBooks;
		this.state = state;
		this.saldo = saldo;
	}


	
	
	@Override
	public void borrowbook(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception{
		
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
			
		}}


	
	
	
	
	String setState(Stato state) {
		this.state = state;
		return "account state alterded";
	}


	@Override
	public String toString() {
		return  this.name;
	}


	public int getPatronID() {
		return userID;
	}


	public void setPatronID(int patronID) {
		this.userID = patronID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public void setBorrowedBooks(ArrayList<Libro> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}


	public String getPatronPASS() {
		return userPASS;
	}


	public void setPatronPASS(String patronPASS) {
		this.userPASS = patronPASS;
	}


	
	public void setStato(Stato stat) {
		this.state = stat;
	}
	





	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	
	public void visualizzaPostiDisponibili() {
		
		prenotaPostoStudio.visualizzaPostiDisponibili();
	}
	
	public void prenotaPosto(int numeroPosto, int durataPrenotazione) {
		
		prenotaPostoStudio.prenotaPosto(this, numeroPosto, durataPrenotazione);
		
	}




	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String propertyName = evt.getPropertyName();
        String bookName = ((Libro) evt.getSource()).getTitle();
        boolean isAvailable = (boolean) evt.getNewValue();
        System.out.println(name + " received update: " + bookName + "'s " + propertyName + " changed to " + isAvailable);
		
	}
	

	
	
	
	public void aggiungi_al_carello(Libro libro) {
		Biblioteca biblio= Biblioteca.getInstance();
		
		if(libro.isAvailable() && biblio.getBooks().contains(libro))
			carello.add(libro);
		else {
			System.out.println("Unable to add book");
		}
			return;
	}
	
	
	
	public ArrayList<Libro> getCarello() {
		return carello;
	}
	
	
	
	
	public void richiestaRicaricaSaldo(double amount) {
		Biblioteca biblio=Biblioteca.getInstance();
		if(biblio.ricaricaSaldo(getPatronID(),amount))
			System.out.println("Ricarica effettuata con successo");
		else {
			System.out.println("Impossibilità fare ricarica. userID notfound or amount negative");
		}
	}
	
	
	
	public void acquistaLibri() {
		Biblioteca biblio= Biblioteca.getInstance();
		Acquistare acquire= new Acquistare();
		acquire.acquista(biblio.getPatrono(getPatronID()),carello);
		
		return;
	}
	
	
	
	
	
}
