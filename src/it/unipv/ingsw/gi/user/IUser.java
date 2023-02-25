package it.unipv.ingsw.gi.user;

import java.util.ArrayList;

public interface IUser {

	// metodi relativi agli aggiornamenti dei libri User 
		public ArrayList<User> selectAll();
		
	// metodo per stampare l'elenco dei user contenuti nella data base 
		public ArrayList<User> selectBYNOME(User usInput);
		
		// metodo per  inserire/aggiungere un nuovo user 
		public boolean insertUser(User U);
		
}
