package it.unipv.ingsw.gi.tests;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;

public class Anothaone {
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		AdminDAO test = new AdminDAO();
		
		
		
		test.agguingiLibro(lib1);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
