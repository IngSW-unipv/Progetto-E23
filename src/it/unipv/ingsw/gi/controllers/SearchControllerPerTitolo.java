package it.unipv.ingsw.gi.controllers;

import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.ricercalibro.RicercaPerTitolo;

public class SearchControllerPerTitolo implements SearchController<String>{
	
	
	
	RicercaPerTitolo rpt = new RicercaPerTitolo();
	
	
	


	@Override
	public ArrayList<Libro> ricerca(ArrayList<Libro> catalogo, String title) {
		return rpt.ricerca(catalogo, title);
	}

}
