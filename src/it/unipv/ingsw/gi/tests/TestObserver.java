package it.unipv.ingsw.gi.tests;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class TestObserver {
	
	    public static void main(String[] args) {
	        Libro book = new Libro(0, null, null, true, null, 0);
	        Admin admin1 = new Admin(0, null, null);
	        Admin admin2 = new Admin(0, null, null);
	        Patrono pat = new Patrono(0, null, null, null, null, 0);
	        
	        book.addPropertyChangeListener(admin2);
	        book.addPropertyChangeListener(admin1);
	        book.addPropertyChangeListener(pat);
	        
	        book.setIsAvailable(false);
	        
	    }
	}


