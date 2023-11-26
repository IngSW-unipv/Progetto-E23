package it.unipv.ingsw.gi.tests;


import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;

import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class Tests {

	public static void main(String[] args) {
		
		
		Libro booktest = new Libro(34,"the sailor who fell from grace","mishima", true,Lang.English,60);
		ArrayList<Libro> borrowedBooks = new ArrayList<Libro>();
		
		Patrono patrontest = new Patrono(1, "password", "john doe",borrowedBooks,  Stato.active,0.0);
		
		Biblioteca librarytest = Biblioteca.getInstance();
		librarytest.books.add(booktest);
		librarytest.patrons.add(patrontest);

		//patrontest.borrowbook(booktest, LocalDate.now(), patrontest, librarytest);

	/*	PrendeInPrestito test1 = new PrendeInPrestito(patrontest, booktest, LocalDate.of(2022, 5, 5), librarytest);
		librarytest.listPrestiti.add(test1);
		patrontest.borrowedBooks.add(booktest);

		System.out.println(librarytest.listPrestiti);

		System.out.println(patrontest.borrowedBooks);

		patrontest.returnbook(test1, librarytest, patrontest);*/

		System.out.println(librarytest.listPrestiti);

		System.out.println(patrontest.borrowedBooks);

	}

}
