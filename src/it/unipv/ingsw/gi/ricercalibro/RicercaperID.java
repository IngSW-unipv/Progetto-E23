package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import java.util.List;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Patrono;

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
	    
	    
	    public ArrayList<Libro> ricerca2(List<Libro> catalogo, Integer id) {
	    	 ArrayList<Libro> risultati = new ArrayList<>();

	    	 for (Libro libro : catalogo) {
	             if (libro.bookID == id) {
	                 risultati.add(libro);
	                 System.out.println(risultati);
	             }
	         }
	         return risultati;
	     }
	    
	    
	    
	    public ArrayList<Patrono> ricercaPat(List<Patrono> catalogo, Integer id) {
	    	 ArrayList<Patrono> risultati = new ArrayList<>();

	    	 for (Patrono pat : catalogo) {
	             if (pat.userID == id) {
	                 risultati.add(pat);
	                 System.out.println(risultati);
	             }
	         }
	         return risultati;
	     }
	 
	 
	 
	    }