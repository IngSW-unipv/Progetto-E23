package it.unipv.ingsw.gi.ricercalibro;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;

public class RicercaPerAutore implements SearchStrategy<String>{

	@Override
	public ArrayList<Libro> ricerca(List<Libro> catalogo, String autore) {
		
		 ArrayList<Libro> risultati = new ArrayList<>();
		
		

	        for (Libro libro : catalogo) {
	        	
	            // La ricerca può essere case-insensitive
	            if (libro.getAuthor().toLowerCase().contains(autore.toLowerCase()) ) {
	                risultati.add(libro);
	            }
	        }
			return risultati;
	 
            } 

}

/* String searchType = (String) searchTypeComboBox.getSelectedItem();
                String searchInput = searchField.getText();

                SearchStrategy searchStrategy;
                if ("Per Titolo".equals(searchType)) {
                    searchStrategy = new RicercaPerTitolo();
                } else if ("Per Autore".equals(searchType)) {
                    searchStrategy = new RicercaPerAutore();
                } else {
                    return;
                }

                List<Libro> risultati = searchStrategy.ricerca(catalogo, searchInput);

                if (risultati.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nessun risultato trovato per il criterio di ricerca.");
                } else {
                    Libro libroDaAcquistare = (Libro) JOptionPane.showInputDialog(
                            null,
                            "Scegli il libro da acquistare :",
                            "Seleziona il libro",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            risultati.toArray(),
                            risultati.get(0));

                    if (libroDaAcquistare != null) {
                        double prezzoLibro = libroDaAcquistare.getPrezzo();
                        double somma = Double.parseDouble(JOptionPane.showInputDialog("Inserisci l'importo :"));

                        if (somma >= prezzoLibro) {
                            JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo: " + libroDaAcquistare.getTitolo());
                        } else {
                            JOptionPane.showMessageDialog(null, "Fondi insufficienti per l'acquisto del libro.");
                        }
                    }
                }*/
