package it.unipv.ingsw.gi.controllers;

import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Libro;

public interface SearchController<T> {

	public ArrayList<Libro> ricerca(ArrayList<Libro> catalogo,T criterio);
	
}
