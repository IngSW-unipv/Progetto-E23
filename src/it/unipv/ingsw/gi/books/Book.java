package it.unipv.ingsw.gi.books;

import java.text.DateFormat;
import java.util.Date;

public class Book {
	public String name;
	public String subject;
	public String publisher;
	public Format format;
	public Language lang;
	public double ISBN ;
	
	
	
	public Book(String name, String subject, String publisher, Format format, Language lang, double iSBN) {
		super();
		this.name = name;
		this.subject = subject;
		this.publisher = publisher;
		this.format = format;
		this.lang = lang;
		ISBN = iSBN;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public Format getformat() {
		return format;
	}



	public Format setformat(Format format) {
		return this.format = format;
	}



	public Language getLang() {
		return lang;
	}



	public void setLang(Language lang) {
		this.lang = lang;
	}



	public double getISBN() {
		return ISBN;
	}



	public void setISBN(double iSBN) {
		ISBN = iSBN;
	}
	
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Book ("+ISBN+", "+name+", "+subject+", "+publisher+", "+format+","+lang+")";
	}
	
	
	

}
