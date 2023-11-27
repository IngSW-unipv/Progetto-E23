package it.unipv.ingsw.gi.tests;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.library.Biblioteca;

public class BibfunTest {
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		Biblioteca bib = Biblioteca.getInstance();
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		AdminDAO test = new AdminDAO();
		test.agguingiLibro(lib1,bib);
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
