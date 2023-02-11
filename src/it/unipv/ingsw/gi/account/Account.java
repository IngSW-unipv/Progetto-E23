package it.unipv.ingsw.gi.account;

import java.util.*;

public class Account {
	public double id;
	public double OPENDATE;
	ArrayList History = new ArrayList();
	public AccountState state;
	LinkedList dueBooks = new LinkedList();
	
	
	public Account(double id, double oPENDATE, ArrayList history, AccountState state, LinkedList dueBooks) {
		super();
		this.id = id;
		OPENDATE = oPENDATE;
		History = history;
		this.state = state;
		this.dueBooks = dueBooks;
	}


	private double getId() {
		return id;
	}


	private void setId(double id) {
		this.id = id;
	}


	private double getOPENDATE() {
		return OPENDATE;
	}


	private void setOPENDATE(double oPENDATE) {
		OPENDATE = oPENDATE;
	}


	private AccountState getState() {
		return state;
	}


	private void setState(AccountState state) {
		this.state = state;
	}
	
	
	
	
	

}
