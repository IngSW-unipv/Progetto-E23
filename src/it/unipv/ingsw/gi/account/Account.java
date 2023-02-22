package it.unipv.ingsw.gi.account;

import java.util.*;

import it.unipv.ingsw.gi.books.Book;
import it.unipv.ingsw.gi.user.User;

public class Account {
	public double id;
	public Date OPENDATE;
	ArrayList<Book> History = new ArrayList<Book>();
	public AccountState state;
	LinkedList<Book> dueBooks = new LinkedList<Book>();
	
	
	public Account(double id, Date oPENDATE, ArrayList<Book> history, AccountState state, LinkedList<Book> dueBooks) {
		super();
		this.id = id;
		OPENDATE = oPENDATE;
		History = history;
		this.state = state;
		this.dueBooks = dueBooks;
	}


	public double getId() {
		return id;
	}
	private void setId(double id) {
		this.id = id;
	}


	public Date getOPENDATE() {
		return OPENDATE;
	}
	private  void setOPENDATE(Date oPENDATE) {
		OPENDATE = oPENDATE;
	}


	
	private AccountState getState() {
		return state;
	}
	private void setState(AccountState state) {
		this.state = state;
	}
	
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Account ("+id+", "+OPENDATE+", "+state+")";
	}


	public User[] getUsers() {
		// TODO Auto-generated method stub
		return null;
	}





	


	


	
	
	

}
