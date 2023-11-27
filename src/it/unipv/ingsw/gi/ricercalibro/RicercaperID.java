package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Libro;


public class RicercaperID  implements SearchStrategy<Integer>{



	@Override
	public ArrayList<Libro> ricerca(ArrayList<Libro> catalogo, Integer id) {
		ArrayList<Libro> risultati = new ArrayList<>();

		for (Libro libro : catalogo) {
			if (libro.bookID == id) {
				risultati.add(libro);
				System.out.println(risultati);
			}
		}
		return risultati;
	}





}