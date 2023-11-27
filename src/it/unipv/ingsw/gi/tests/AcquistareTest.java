package it.unipv.ingsw.gi.tests;

import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class AcquistareTest {
	
	public static void main(String[] args) {

	Biblioteca T= Biblioteca.getInstance();
	Patrono pat= new Patrono(0, "test", "test", null, Stato.active, 1000);
	System.out.println(pat);
	
	Libro lib0= new Libro(1, "Fisica", "Newton", true, Lang.French, 15);
	Libro lib1= new Libro(2, "Matematica", "Isaac", true, Lang.French, 20);
	Libro lib2= new Libro(3, "Religione", "Papa", true, Lang.English, 505);
	pat.carello = new ArrayList<Libro>();
	pat.aggiungi_al_carello(lib0);
	System.out.println(pat);
	T.patrons.add(pat);
	pat.aggiungi_al_carello(lib0);
	System.out.println(pat);
	T.addBook(lib0);
	T.addBook(lib1);
	T.addBook(lib2);
	pat.aggiungi_al_carello(lib1);
	pat.aggiungi_al_carello(lib2);
	System.out.println(pat);
	pat.acquistaLibri();
}
}
