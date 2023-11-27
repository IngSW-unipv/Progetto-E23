package it.unipv.ingsw.gi.library;

import java.util.ArrayList;
import java.util.List;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.users.Patrono;


public class Acquistare {
	private Biblioteca biblioteca;
	private final double tasse= 0.22;
	private double costo_Totale; // iva inclusa
	
	public Acquistare() {
		biblioteca= Biblioteca.getInstance();
		costo_Totale =0;
	}

		
	public boolean acquista(Patrono patrono, ArrayList<Libro> carello) {
		if(carello==null||carello.size()==0) {
			System.out.println("Carello Vuoto: Inserisci libro/libri d'acqistare");
			return false;
			}
		
		else
			costo_Totale = calcolo_Costo(carello);
			
			
		if(!(debit_Patrono(patrono, costo_Totale))) {
			System.out.println("insufficient funds in patron's account");
			return false;
				}
		
			credit_Library_account(costo_Totale);
			for (Libro libro: carello) {
				biblioteca.getBooks().remove(libro);
				
			}
			System.out.println("Libro acquistato con successo");

		carello.removeAll(carello);
			return true;
	}
	
	
	public double calcolo_Costo(List<Libro> libri) {
		double costo=0;
		for(Libro libro: libri)  
			costo += libro.getPrezzo();
				
		return costo*(1+tasse);
	}
	
	
	public boolean debit_Patrono(Patrono patron, double amount) {
		if(patron.saldo<amount)
			return false;
		else 
			patron.saldo-=amount;
				return true;
		}
	public void credit_Library_account( double amount) {
		if(amount>0)
				biblioteca.credit_Conto_Biblio(amount);
		
				return;
		}
	
}
