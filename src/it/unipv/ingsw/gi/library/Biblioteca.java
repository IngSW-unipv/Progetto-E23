package it.unipv.ingsw.gi.library;


import java.awt.EventQueue;
import java.io.Serializable;
import java.util.ArrayList;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.patrongui.LogGUI;
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
	private double conto_Biblio;



	/**1	11111
	 * this is the main class for the project 
	 * it holds all the important data and also has its related methods
	 * 
	 * @param listPrestiti list of the books
	 * @param name the name of the library 
	 * @param patrons list of all patrons signed to the library
	 * @param admins list of all the admins registered to the library
	 * @param books list of all the books in the catalog
	 */
	private Biblioteca(ArrayList<PrendeInPrestito> listPrestiti, String name, ArrayList<Patrono> patrons,
			ArrayList<Admin> admins, ArrayList<Libro> books) {
		super();
		this.listPrestiti = listPrestiti;
		this.name = name;
		this.patrons = patrons;
		this.admins = admins;
		this.books = books;
	}


	/**
	 * method for the pattern singleton to call the unique instance wherever need
	 * @return the unique instance created using the singleton pattern 
	 */
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

	
	
	/**
	 * override of the toString method to have it output the name of the library
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * method to authenticate the log in credentials of the users whether its an admin or a patron
	 * 
	 * @param usernameID the id of the user
	 * @param password the password of the user
	 * 
	 * @return is a text of the type of user if the credentials are correct or an invalid text if it's incorrect
	 */
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


	/**
	 * method to add a book to the catalog
	 * @param libro the book getting added
	 */
	public void addBook(Libro libro) {
		if (!(books.contains(libro))) {
			books.add(libro);
			System.out.println("libro aggiunto con successo");

		}
		else 
			System.out.println("libro già presente in biblioteca");

		return;
	}

	/**
	 * method to delete a book from the catalog
	 * @param libro the book getting deleted
	 */
	public void canBook(Libro libro) {
		if (books.contains(libro)) {
			books.remove(libro);
			System.out.println("book removed succefully!");

		}
		else {
			System.out.println("book doesn't exist");
		}
	}


	
	/**
	 * method to add a patron to the database
	 * @param patrono the patron getting added
	 */
	public void addPatrono(Patrono patrono) {
		if (!(patrons.contains(patrono))) {
			patrons.add(patrono);
			System.out.println("patrono aggiunto con successo");

		}
		else 
			System.out.println("patrono già presente in biblioteca");

		return;
	}

	/**
	 * method to delete a patron from the database
	 * @param patrono the patron getting deleted
	 */
	public void canPatrono(Patrono patrono) {
		if(patrons.contains(patrono)) {
			patrons.remove(patrono);
			System.out.println("patron removed succefully!");
		}
		else {
			System.out.println("patron doesn't exist");
		}
	}


	
	public ArrayList<Libro> getBooks() {
		return books;
	}


	public void credit_Conto_Biblio(double cifra) {
		conto_Biblio+= cifra;
	}

	public double getConto_Biblio() {
		return conto_Biblio;
	}

	public Patrono getPatrono(int userID) {
		Patrono patrono=null;
		for (Patrono pat: patrons)  
			if (pat.getPatronID()==userID) {
				System.out.println("Patrono trovato");
				patrono=pat;
				return patrono;
			}

		System.out.println("Patrono non trovato");
		return patrono;
	}

	
	public boolean ricaricaSaldo(int userID,double amount) {
		Patrono patron=getPatrono(userID);
		if (patrons.contains(patron)&&amount>0) { 
			patron.saldo+=amount;
			return true;
		}
		else 
			return false;					
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

