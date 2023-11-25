package it.unipv.ingsw.gi.service;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class BibServices {

	private PatronoDAO patdao;
	private BibDAO bibdao;
	private AdminDAO admdao;

	public BibServices(PatronoDAO patdao,BibDAO bibdao,AdminDAO admdao) {
		super();
		this.patdao = patdao;
		this.bibdao = bibdao;
		this.admdao = admdao;
	}

	public void servBorrowBook(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception{

		patdao.borrowBookDao(book, date, patron, library);
	}

	public void serRisBook(Libro libro , Biblioteca library,Patrono patron) throws Exception{

		admdao.returnBookDao(libro, library, patron);

	}

	public void servRecPat(Biblioteca bib) {
		bibdao.recPat(bib);
	}

	public void servRecLib(Biblioteca bib) {
		bibdao.recLib(bib);
	}

	public void serRecAdm(Biblioteca bib) {
		bibdao.recAdm(bib);
	}

	public void serCambStato(Patrono patrono,Stato state) throws Exception{
		admdao.cambioStatoDAO(patrono, state);
	}

	public void serAggLib(Libro libro,Biblioteca biblio) throws Exception{
		admdao.agguingiLibro(libro,biblio);
	}


	public void serDelLibro(Libro libro,Biblioteca biblioteca) throws Exception{
		admdao.cancellaLibro(libro, biblioteca);
	}

	public void serAggPat(Patrono patrono,Biblioteca biblioteca) throws Exception{
		admdao.agguingiPatrono(patrono, biblioteca);
	}

	public void serDelPat(Patrono patrono, Biblioteca biblioteca) throws Exception{
		admdao.cancellapatron(patrono, biblioteca);
	}


}
