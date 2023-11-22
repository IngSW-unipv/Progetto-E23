package it.unipv.ingsw.gi.users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.posti.PrenotazionePostoStudio;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;

public class Patrono extends Persona implements Functions , Serializable{


	public ArrayList<Libro> borrowedBooks;
	public Stato state;
	public double saldo;
	public ArrayList<Libro> carello;
	private PrenotazionePostoStudio prenotaPostoStudio;
	

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


	private ArrayList<Libro> getBorrowedBooks() {
		return borrowedBooks;
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
	


	private Stato getState() {
		return state;
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
	

	
	
	
	
}