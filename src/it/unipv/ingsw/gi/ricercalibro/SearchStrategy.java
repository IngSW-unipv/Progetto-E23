package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import java.util.List;

import it.unipv.ingsw.gi.books.Libro;

public interface SearchStrategy<T> {
	
	
	public List<Libro> ricerca(List<Libro> catalogo, T criterioRicerca);

}