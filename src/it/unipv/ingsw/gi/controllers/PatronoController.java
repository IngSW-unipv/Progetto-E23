package it.unipv.ingsw.gi.controllers;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;

import it.unipv.ingsw.gi.library.Biblioteca;

import it.unipv.ingsw.gi.users.Patrono;

public class PatronoController {

	Patrono patrono;
	
	public PatronoController(Patrono patrono) {
		this.patrono = patrono;
	}


	public void borrowButtonClick(Libro book,LocalDate date,Patrono patron,Biblioteca library) {
		try {
			patron.borrowbook(book, date, patron, library);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
