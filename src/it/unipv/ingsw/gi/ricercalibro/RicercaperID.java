package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import java.util.List;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.PrendeInPrestito;

public class RicercaperID  {


	    public ArrayList<PrendeInPrestito> ricerca(List<PrendeInPrestito> catalogo, Integer id) {
	    	 ArrayList<PrendeInPrestito> risultati = new ArrayList<>();

	    	 for (PrendeInPrestito libro : catalogo) {
	             if (libro.libro.getBookID() == id) {
	                 risultati.add(libro);
	                 System.out.println(risultati);
	             }
	         }
	         return risultati;
	     }
	 
	 
	 
	    }