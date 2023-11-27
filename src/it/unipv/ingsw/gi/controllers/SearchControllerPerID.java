package it.unipv.ingsw.gi.controllers;

import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class SearchControllerPerID {
	
	RicercaperID rpi = new RicercaperID();
	
	

	
	public ArrayList<Libro> ricercaLibroperIdbuttonpress(ArrayList<Libro> catalogo,Integer id) {
		return rpi.ricerca(catalogo, id);
	}
	
	public ArrayList<PrendeInPrestito> ricercaPrenperIdbuttonpress(ArrayList<PrendeInPrestito> catalogo,Integer id,Admin admin) {
		return admin.ricerca2(catalogo, id);
	}
	
	
	public ArrayList<Patrono> ricercaPatperIdbuttonpress (ArrayList<Patrono> catalogo,Integer id,Admin admin) {
		return admin.ricercaPat(catalogo, id);
	}
	
	

}
