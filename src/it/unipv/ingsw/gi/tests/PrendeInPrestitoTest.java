package it.unipv.ingsw.gi.tests;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class PrendeInPrestitoTest {

	@Test
	public void prendeInPrestitoTest() {
		Biblioteca bib = Biblioteca.getInstance();
		ArrayList<Libro> borrowedBooks = new ArrayList<Libro>();
		Patrono patrontest = new Patrono(1, "password", "john doe",borrowedBooks,  Stato.active,0.0);
		Admin admintest = new Admin(0, "admin", "test");
		Libro booktest = new Libro(34,"the sailor who fell from grace","mishima", true,Lang.English,60);
		bib.patrons.add(patrontest);
		try {
			patrontest.borrowbook(booktest, LocalDate.now(), patrontest, bib);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrendeInPrestito test1 = new PrendeInPrestito(patrontest, booktest, LocalDate.of(2022, 12, 27), bib);
		ArrayList<Libro> expected = new ArrayList<>();
		ArrayList<PrendeInPrestito> expected2 = new ArrayList<>();
		expected.add(booktest);
		expected2.add(test1);

		assertEquals(patrontest.borrowedBooks,expected);
		assertEquals(booktest.isAvailable,false);
		try {
			admintest.returnbook(test1, bib, patrontest,admintest);
			expected.remove(booktest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(patrontest.borrowedBooks,expected);
		assertEquals(booktest.isAvailable,true);
	}

}

