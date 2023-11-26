package it.unipv.ingsw.gi.controllers;

import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.ricercalibro.RicercaPerAutore;




public class SearchControllerPerAutore implements SearchController<String>{

	
	RicercaPerAutore rpa = new RicercaPerAutore();
	
	


	@Override
	public ArrayList<Libro> ricerca(ArrayList<Libro> catalogo,String autore) {
		
		return rpa.ricerca(catalogo, autore);
	}



	
	
	
	
	
	
}
