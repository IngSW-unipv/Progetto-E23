package it.unipv.ingsw.gi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

public class BibDAO implements IBibDAO{


	MyDbaseconnect dbConnect = MyDbaseconnect.getInstance();


	//method to recall all patrons from database to the library array
	@Override
	public void recPat(Biblioteca bib) {
		// TODO Auto-generated method stub

		try (Connection conn = dbConnect.getConnection();

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
				bib.patrons.add(pat);
				
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your application's needs
		}



		System.out.println(bib.patrons);

	}

	//method to recall all the books from datatbase to the library array
	@Override
	public void recLib(Biblioteca bib) {
		// TODO Auto-generated method stub



		try (Connection conn = dbConnect.getConnection();
				Statement libstatement = conn.prepareStatement("SELECT * from bibfin.libro");

				ResultSet resultSet = libstatement.executeQuery("SELECT * from bibfin.libro")) {

			while (resultSet.next()) {
				Libro book = new Libro(0, "", "", null, null, 0.0);
				book.setBookID(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				String stateValue = resultSet.getString("lingua");
				Lang langEnum = Lang.valueOf(stateValue);
				book.setLanguage(langEnum);
				book.setIsAvailable(resultSet.getBoolean("isAvailable"));
				book.setPrezzo(resultSet.getDouble("prezzo"));
				bib.books.add(book);
				
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your application's needs
		}



		System.out.println(bib.books);










	}

	//method to recall all the admins from the database to the library array
	@Override
	public void recAdm(Biblioteca bib) {
		// TODO Auto-generated method stub


		try (Connection conn = dbConnect.getConnection();
				Statement libstatement = conn.prepareStatement("SELECT * from bibfin.admins");

				ResultSet resultSet = libstatement.executeQuery("SELECT * from bibfin.admins")) {

			while (resultSet.next()) {
				Admin ad = new Admin(0, null, null);
				ad.setAdminID(resultSet.getInt("userID"));
				ad.setAdminnPASS(resultSet.getString("userpass"));
				ad.setName(resultSet.getString("name"));
				bib.admins.add(ad);
				
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your application's needs
		}



		System.out.println(bib.admins);




	}





}
