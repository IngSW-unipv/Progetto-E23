package it.unipv.ingsw.gi.books;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**book class with correlating methods 
 * 
 * @author nassa
 *
 */
public class Libro {
	public int bookID;
	public String title;
	public String author;
	public Boolean isAvailable;
	public Lang language;
	public double prezzo;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	
	/**book constructor 
	 * 
	 * @param bookID
	 * @param title
	 * @param author
	 * @param isAvailable
	 * @param language
	 * @param prezzo
	 */
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


	public boolean isAvailable() {
		return isAvailable;
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


	/**
	 * method to set the availability of the book with the added function of the observer pattern
	 * @param isAvailable
	 */
	public void setIsAvailable(Boolean isAvailable) {
		Boolean oldavai = this.isAvailable;
		this.isAvailable = isAvailable;
		propertyChangeSupport.firePropertyChange("isAvailable", oldavai, isAvailable);

	}




	public double getPrezzo() {
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


	/**
	 * method to add the observer 
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	/**
	 * method to remove the observer
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}




}
