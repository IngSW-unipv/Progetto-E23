package it.unipv.ingsw.gi.dao;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;

public interface IAdminDAO {

	public void agguingiLibro(Libro libro,Biblioteca biblioteca) throws Exception;
	public void agguingiPatrono(Patrono patrono,Biblioteca biblioteca) throws Exception;
	public void returnBookDao(Libro libro , Biblioteca library,Patrono patron) throws Exception;
	public void cancellaLibro(Libro libro,Biblioteca biblioteca) throws Exception;
	public void cancellapatron(Patrono patrono,Biblioteca biblioteca)throws Exception;

}
