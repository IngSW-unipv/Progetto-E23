package it.unipv.ingsw.gi.books;

import java.text.DateFormat;

public class Book {
	public String name;
	public String subject;
	public String publisher;
	public DateFormat publicationDate;
	public Language lang;
	public String ISBN ;
	
	
	public Book(String name, String subject, String publisher, DateFormat publicationDate, Language lang, String iSBN) {
		super();
		this.name = name;
		this.subject = subject;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.lang = lang;
		ISBN = iSBN + "001";
	}
	
	
	
	
	

}
