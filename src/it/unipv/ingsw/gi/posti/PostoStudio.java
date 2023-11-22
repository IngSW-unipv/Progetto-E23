package it.unipv.ingsw.gi.posti;

import java.util.HashMap;
import java.util.Map;


public class PostoStudio {
	
	private boolean disponibile;// disponibilità o no del posto
	// costruttore che inizializza il posto disponibile quando viene creato.
	public PostoStudio() {
		this.disponibile = true;
	}
	// restituisce lo stato di disponibilità del posto
	public boolean isDisponibile() {
		return disponibile;
	}
	// metodo che imposta il posto come non disponibile
	public void occupaPosto() {
		this.disponibile = false ;
	}
	public void liberaPosto() {
		this.disponibile = true;
	}

	protected Map<Integer,PostoStudio> postiStudio = new HashMap<>();

}
