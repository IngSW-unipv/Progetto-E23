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


	
	public AccountState getState() {
		return state;
	}
	private void setState(AccountState state) {
		this.state = state;
	}
	
	
	
	public ArrayList<Book> getHistory() {
		return History;
	}


	public void setHistory(ArrayList<Book> history) {
		History = history;
	}


	public LinkedList<Book> getDueBooks() {
		return dueBooks;
	}


	public void setDueBooks(LinkedList<Book> dueBooks) {
		this.dueBooks = dueBooks;
	}


	public String toString() {
		return "Account ("+id+", "+OPENDATE+", "+state+", "+History+", "+dueBooks+")";
	}


	public User[] getUsers() {
		return null;
	}





	


	


	
	
	

}
