package it.unipv.ingsw.gi.dao;

import java.time.LocalDate;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;

public interface IPatronoDAO {


	public void borrowBookDao(Libro book,LocalDate date,Patrono patron,Biblioteca library) throws Exception;




}
