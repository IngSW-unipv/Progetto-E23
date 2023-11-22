package it.unipv.ingsw.gi.tests;
import it.unipv.ingsw.gi.users.Persona;
import it.unipv.ingsw.gi.users.Stato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;



public class Randomtests {

	
	public static void main(String[] arg) {
	
	/*LocalDate date = LocalDate.now();
	date = LocalDate.now().plus(30, ChronoUnit.DAYS);
	
	
	Persona x = new Patrono(0, null, null, null, Stato.active,0.0);
	Patrono y = new Patrono(0, null, null, null, null,0.0);
	
	
	System.out.println(date);
	
	System.out.println(x instanceof Persona);
	
	System.out.println(x instanceof Patrono);
	
	System.out.println(y instanceof Persona);
	
	System.out.println(y instanceof Patrono);*/
		
		

		ArrayList<Patrono> patrons = new ArrayList<>();
		ArrayList<Admin> admins = new ArrayList<>();
		ArrayList<PrendeInPrestito> books = new ArrayList<>();
		ArrayList<Libro> avaiBooks = new ArrayList<>();
		Biblioteca bib1 = new Biblioteca (books, "bib1", patrons, admins,avaiBooks);
		Patrono pat1 = new Patrono(1234,"pass", "jack", avaiBooks, Stato.active,0.0);
		
		Libro lib1 = new Libro(123, "potere", "swagger", true, Lang.English, 22.2);
		
		
		
		
		
		
	/*	MyDbaseconnect dbConnect ;
		 try (Connection conn = MyDbaseconnect.getConnection();
	            Statement patstatement = conn.prepareStatement("SELECT * from bibfin.libro");

	            ResultSet resultSet = patstatement.executeQuery("SELECT * from bibfin.libro")) {
			 
	            while (resultSet.next()) {
	                Libro book = new Libro(0, "", "", null, null, 0.0);
	                book.setBookID(resultSet.getInt("id"));
	                book.setTitle(resultSet.getString("title"));
	                book.setAuthor(resultSet.getString("author"));
	                String stateValue = resultSet.getString("language");
	                Lang langEnum = Lang.valueOf(stateValue);
	                book.setLanguage(langEnum);
	                book.setIsAvailable(resultSet.getBoolean("isAvailable"));
	                book.setPrezzo(resultSet.getDouble("prezzo"));
	                bib1.books.add(book);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception according to your application's needs
	        }
		 
		 
		 
		 System.out.println(bib1.books);
	
	}*/
		
		
		/*	List<Libro> catalogo = new ArrayList<>();
		catalogo.add(new Libro(1, "Il Signore degli Anelli", "J.R.R. Tolkien", 25.99, Language.ENGLISH, true));
	    catalogo.add(new Libro(2, "1984", "George Orwell", 19.99, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(3, "1984", "Jane Austen", 18.50, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(4, "Cronache di Narnia", "George Orwell", 22.75, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(5, "harry potter", "mary blu", 30, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(6, "harry lidelman", "C.S. Lewis", 23, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(7, "attack on titan", "karl stone", 20.30, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(8, "my family", "karl stone", 22.75, Language.ITALIAN, false));
	    
	    catalogo.add(new Libro(9, "green bad", "arthur ni", 45, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(34, "green bad", "arthur ni", 45, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(33, "green bad", "arthur ni", 45, Language.ITALIAN, true));
	    
	    catalogo.add(new Libro(10, "green lanter", "karl stone", 22.75, Language.ITALIAN, true));
		
		
	   
	    
	 
	    RicercaperID ricercaPerID = new RicercaperID();
	 
	 ricercaPerID.ricerca(catalogo, 33);*/
	
	/*	MyDbaseconnect dbConnect ;
		 try (Connection conn = MyDbaseconnect.getConnection();
	            Statement patstatement = conn.prepareStatement("SELECT * from bibfin.patrono");

	            ResultSet resultSet = patstatement.executeQuery("SELECT * from bibfin.patrono")) {
			 
	            while (resultSet.next()) {
	            	
	            	Patrono pat = new Patrono(0, null, null, null, null, 0);
	            	ArrayList<Libro> prev = new ArrayList<Libro>();
	                pat.setName(resultSet.getString("name"));
	                pat.setPatronID(resultSet.getInt("id"));
	                pat.setPatronPASS(resultSet.getString("userPass"));
	                String stateValue = resultSet.getString("stato");
	                Stato statoEnum = Stato.valueOf(stateValue);
	                pat.setStato(statoEnum);
	                pat.setBorrowedBooks(prev);
	                
	                pat.setSaldo(resultSet.getDouble("saldo"));
	                bib1.patrons.add(pat);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception according to your application's needs
	        }
		 
		 
		 
		 System.out.println(bib1.patrons);
	*/
		
		
		
		
		try (Connection conn = MyDbaseconnect.getConnection();
	            Statement libstatement = conn.prepareStatement("SELECT * from bibfin.admins");

	            ResultSet resultSet = libstatement.executeQuery("SELECT * from bibfin.admins")) {
			 
	            while (resultSet.next()) {
	                Admin ad = new Admin(0, null, null);
	                ad.setAdminID(resultSet.getInt("userID"));
	                ad.setAdminnPASS(resultSet.getString("userpass"));
	                ad.setName(resultSet.getString("name"));
	                bib1.admins.add(ad);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception according to your application's needs
	        }
		
		
		
		System.out.println(bib1.admins);
		
		
		
		
		
	}
	
	
}
