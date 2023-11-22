package it.unipv.ingsw.gi.books;

public class Libro {
	public int bookID;
	public String title;
	public String author;
	public Boolean isAvailable;
	public Lang language;
	public double prezzo;
	
	
	
	
	public Libro(int bookID, String title, String author, Boolean isAvailable, Lang language, double prezzo) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
		this.language = language;
		this.prezzo = prezzo;
	}


	@Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + "is available :" + isAvailable;
    }


	public int getBookID() {
		return bookID;
	}


	public void setBookID(int bookID) {
		this.bookID = bookID;
	}


	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	private double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public Lang getLanguage() {
		return language;
	}


	public void setLanguage(Lang language) {
		this.language = language;
	}
	
	
	
	
	

}
