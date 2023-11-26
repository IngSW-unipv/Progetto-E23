package it.unipv.ingsw.gi.controllers;

import java.time.LocalDate;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class AdminController {
	
	Admin admin;

	public AdminController(Admin admin) {
		super();
		this.admin = admin;
	}
	
	
	public void borrowButtonClick(Libro book,LocalDate date,Patrono patron,Biblioteca library) {
		try {
			patron.borrowbook(book, date, patron, library);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void returnButtonClick(PrendeInPrestito bitem, Biblioteca library,Patrono patron,Admin admin) {
		
		try {
			admin.returnbook(bitem, library, patron);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public void cambiaStatoButtonClick(Patrono pat, Stato state,Admin adminn) {
		
		try {
			adminn.cambiaStato(pat, state);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	public void addbookButtonClick(Libro libro,Biblioteca biblio,Admin adminn) {
		try {
			adminn.aggLibro(libro, biblio);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void canbookButtonClick(Libro libro,Biblioteca bib,Admin adminn) {
		
		try {
			adminn.canLibro(libro, bib);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void addPatronoButtonClick(Patrono patrono, Biblioteca bib,Admin adminn) {
		try {
			adminn.aggPatrono(patrono, bib);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void canPatronoButtonClick(Patrono patrono, Biblioteca bib,Admin adminn){
		try {
			adminn.canPatrono(patrono, bib);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

}
