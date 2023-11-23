package it.unipv.ingsw.gi.tests;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.library.Biblioteca;

public class Anothaone {
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		Biblioteca bib = new Biblioteca(null, null, null, null, null);
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		AdminDAO test = new AdminDAO();
		
		
		
		test.agguingiLibro(lib1,bib);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
