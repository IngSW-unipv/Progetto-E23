package it.unipv.ingsw.gi.books;

import java.text.DateFormat;
import java.util.Date;

public class Book {
	public String name;
	public String subject;
	public String publisher;
	public Date publicationDate;
	public Language lang;
	public double ISBN ;
	
	
	
	public Book(String name, String subject, String publisher, Date publicationDate, Language lang, double iSBN) {
		super();
		this.name = name;
		this.subject = subject;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
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



	public Date getPublicationDate() {
		return publicationDate;
	}



	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
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
		return "Book ("+ISBN+", "+name+", "+subject+", "+publisher+", "+publicationDate+","+lang+")";
	}
	
	
	

}
