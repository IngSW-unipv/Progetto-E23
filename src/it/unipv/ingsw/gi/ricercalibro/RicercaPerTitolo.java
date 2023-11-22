package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;

public class RicercaPerTitolo implements SearchStrategy<String>{
	
	 
	 @Override
	    public ArrayList<Libro> ricerca(List<Libro> catalogo, String titolo) {
	    	 ArrayList<Libro> risultati = new ArrayList<>();

	         for (Libro libro : catalogo) {
	        	 
	             // La ricerca può essere case-insensitive quindi posso ottenere il libro che voglio qualunque sia 
	        	 // ma maniera che scrivo (maiuscoo, minuscolo, mescolando, ecc..)
	             if (libro.getTitle().toLowerCase().contains(titolo.toLowerCase())) {
	                 risultati.add(libro);
	                 System.out.println(risultati);
	                 
	             }
	         }
			return risultati;
	         }
	    }
	             
	       /*  
	         if (risultati.size() == 0) {
	        	 System.out.println(" libro corrispondente a titolo non trovato");
	         return libroDesiderato;}
	         
	         
	         if (risultati.size() == 1) {
	         	libroDesiderato = risultati.get(0);
	         	if (libroDesiderato.getDisponibilità() == true) {
	         	System.out.println(libroDesiderato);
	         	} else {
	         		System.out.print("book not available at the moment , please come back later");
	         	}
		        return libroDesiderato ;
		        
		        } 
	         
		        
		        for (Libro libro: risultati) {
		        	System.out.println(libro);
		        }
		    
		         if (risultati.size() > 1) {
		                 Scanner scanner = new Scanner(System.in);
		                 System.out.println("Inserisci l'ID dell'oggetto desiderato:");
		                 int idDesiderato = scanner.nextInt();

		                 // Filtra i risultati in base all'ID fornito
		                  libroDesiderato = trovaLibroConId(risultati, idDesiderato);

		                 // Visualizza l'oggetto desiderato se trovato
		                  if (libroDesiderato != null ) {
		                  	if (libroDesiderato.getDisponibilità() == true) {
		                      System.out.println("Libro desiderato trovato: " + libroDesiderato);
		                  	}
		                  	else {System.out.println("libro non dispobinile");}
		                  	
		                  } else {
		                      System.out.println("Nessun libro trovato con l'ID specificato.");
		                  }

		               // Chiudi lo Scanner
		                  scanner.close();
		                  return libroDesiderato;
		                  }*/
		                  
		             
	    
	  /*  private static Libro trovaLibroConId(List<Libro> lista, int idDesiderato) {
	        for (Libro libro : lista) {
	            if (libro.getBookID() == idDesiderato) {
	                return libro;
	            }
	        }
	        return null; // Se l'oggetto non è stato trovato ecco quello che restituisce
	    } */

