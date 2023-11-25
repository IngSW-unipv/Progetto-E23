package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Patrono;

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



	public ArrayList<Patrono> ricercaPat(ArrayList<Patrono> catalogo, Integer id) {
		ArrayList<Patrono> risultati = new ArrayList<>();

		for (Patrono pat : catalogo) {
			if (pat.userID == id) {
				risultati.add(pat);
				System.out.println(risultati);
			}
		}
		return risultati;
	}




	public ArrayList<PrendeInPrestito> ricerca2(ArrayList<PrendeInPrestito> catalogo, Integer id) {
		ArrayList<PrendeInPrestito> risultati = new ArrayList<>();

		for (PrendeInPrestito libro : catalogo) {
			if (libro.libro.getBookID() == id) {
				risultati.add(libro);
				System.out.println(risultati);
			}
		}
		return risultati;
	}




}