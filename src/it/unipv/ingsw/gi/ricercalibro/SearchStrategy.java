package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Libro;

public interface SearchStrategy<T> {


	public ArrayList<Libro> ricerca(ArrayList<Libro> catalogo, T criterioRicerca);

}