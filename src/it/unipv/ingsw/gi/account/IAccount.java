package it.unipv.ingsw.gi.account;

import java.sql.SQLException;
import java.util.List;

import it.unipv.ingsw.gi.user.User;

public interface IAccount {
	
	 List<Account> selectAll();
	    
	 public default void addAccount(Account account) throws SQLException {};

		boolean createAccount(User user);

		Account selectById(double id);
		
		
	    

}
