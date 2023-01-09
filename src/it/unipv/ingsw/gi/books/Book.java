package it.unipv.ingsw.gi.books;
import it.unipv.ingsw.gi.books.Language;
import java.text.DateFormat;

public class Book {
	private String name;
	private String subject;
	private String publisher;
	private DateFormat publicationDate;
	private Language lang;
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
