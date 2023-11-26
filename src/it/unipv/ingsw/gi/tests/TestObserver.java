package it.unipv.ingsw.gi.tests;
import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class TestObserver {
	
	    public static void main(String[] args) {
	        Libro book = new Libro(34,"the sailor who fell from grace","mishima", true,Lang.English,60);
	        Admin admin1 = new Admin(0, "pass1", "admin 1");
	        Admin admin2 = new Admin(0, "pass", "admin 2");
	        ArrayList<Libro> borrowedBooks = new ArrayList<Libro>();
	        Patrono pat = new Patrono(1, "password", "john doe",borrowedBooks,  Stato.active,0.0);
	        
	        book.addPropertyChangeListener(admin2);
	        book.addPropertyChangeListener(admin1);
	        book.addPropertyChangeListener(pat);
	        
	        book.setIsAvailable(false);
	        
	    }
	}


