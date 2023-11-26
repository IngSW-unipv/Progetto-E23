package it.unipv.ingsw.gi.library;


import java.awt.EventQueue;
import java.io.Serializable;
import java.util.ArrayList;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.gui.LogGUI;
import it.unipv.ingsw.gi.users.Patrono;


public class Biblioteca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<PrendeInPrestito> listPrestiti;
	public String name;
	public ArrayList<Patrono> patrons;
	public ArrayList<Admin> admins;
	public ArrayList<Libro> books;
	private static Biblioteca instance;
	




	private Biblioteca(ArrayList<PrendeInPrestito> listPrestiti, String name, ArrayList<Patrono> patrons,
			ArrayList<Admin> admins, ArrayList<Libro> books) {
		super();
		this.listPrestiti = listPrestiti;
		this.name = name;
		this.patrons = patrons;
		this.admins = admins;
		this.books = books;
	}

	
	//calling the unique instance
	public static Biblioteca getInstance() {

		if (instance == null ) {
			ArrayList<Patrono> patrons = new ArrayList<>();
			ArrayList<Admin> admins = new ArrayList<>();
			ArrayList<PrendeInPrestito> books = new ArrayList<>();
			ArrayList<Libro> avaiBooks = new ArrayList<>();
			instance = new Biblioteca(books, "bib1", patrons, admins, avaiBooks);
		}
		return instance;
	}
	

	public String toString() {
		return this.name;
	}


	public String authenticate(int usernameID, String password) {
		for (Patrono user : patrons) {
			if (user.userID == usernameID && user.userPASS.equals(password)) {
				return "User";
			}
		}

		for (Admin admin : admins) {
			if (admin.userID == usernameID && admin.userPASS.equals(password)) {
				return "Admin";
			}
		}

		return "Invalid";
	}


	public String getName() {
		return name;
	}



	public void addBook(Libro libro) {
		if (!(books.contains(libro))) {
			books.add(libro);
			System.out.println("libro aggiunto con successo");

		}
		else 
			System.out.println("libro già presente in biblioteca");

		return;
	}


	public void canBook(Libro libro) {
		if (books.contains(libro)) {
			books.remove(libro);
			System.out.println("book removed succefully!");

		}
		else {
			System.out.println("book doesn't exist");
		}
	}


	public void addPatrono(Patrono patrono) {
		if (!(patrons.contains(patrono))) {
			patrons.add(patrono);
			System.out.println("patrono aggiunto con successo");

		}
		else 
			System.out.println("patrono già presente in biblioteca");

		return;
	}


	public void canPatrono(Patrono patrono) {
		if(patrons.contains(patrono)) {
			patrons.remove(patrono);
			System.out.println("patron removed succefully!");
		}
		else {
			System.out.println("patron doesn't exist");
		}
	}


	public static void main(String[] args) {



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogGUI window = new LogGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}



}
