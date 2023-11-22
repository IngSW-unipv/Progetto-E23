package it.unipv.ingsw.gi.tests;

import it.unipv.ingsw.gi.dao.PatronoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class PatronoDaoTest {
	

	public static void main(String args[]) throws Exception {
		
		PatronoDAO p1 = new PatronoDAO();
		ArrayList<Patrono> patrons = new ArrayList<>();
		ArrayList<Admin> admins = new ArrayList<>();
		ArrayList<PrendeInPrestito> books = new ArrayList<>();
		ArrayList<Libro> avaiBooks = new ArrayList<>();
		Biblioteca bib1 = new Biblioteca (books, "bib1", patrons, admins,avaiBooks);
		Patrono pat1 = new Patrono(1234,"pass", "jack", avaiBooks, Stato.active,0.0);
		bib1.patrons.add(pat1);
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		bib1.books.add(lib1);
		
		p1.borrowBookDao(lib1, LocalDate.now(), pat1, bib1);
		
		
		
	}

}
