package it.unipv.ingsw.gi.books;
import java.text.DateFormat;

public class Author {
	private String name;
	private String biography;
	private DateFormat birthdate;
	
	private Author(String name, String biography, DateFormat birthdate) {
		super();
		this.name = name;
		this.biography = biography;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public String getBiography() {
		return biography;
	}
	public DateFormat getBirthdate() {
		return birthdate;
	}

	
}
