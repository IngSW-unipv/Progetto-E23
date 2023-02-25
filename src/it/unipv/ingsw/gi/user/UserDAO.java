package it.unipv.ingsw.gi.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsw.gi.books.Book;
import it.unipv.ingsw.gi.books.Language;
import it.unipv.ingsw.gi.dbase.*;
import it.unipv.insw.gi.librarian.search;

public class UserDAO implements search{
	
	
	 private Connection connection;

	    public UserDAO() {
	        connection = MyDbaseconnect.getConnection();
	    }
	    public ArrayList<Book> getAllBooks() {
	        String query = "SELECT * FROM books";
	        ArrayList<Book> books = new ArrayList<>();
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                String name = resultSet.getString("name");
	                String subject = resultSet.getString("subject");
	                String publisher = resultSet.getString("publisher");
	                Date publicationDate = resultSet.getDate("publicationDate");
	                Language lang = Language.valueOf(resultSet.getString("language"));
	                String isbn = resultSet.getString("isbn");
	                Book book = new Book(name, subject, publisher, publicationDate, lang, 245);
	                books.add(book);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return books;
	    }

	
public ArrayList<Book> getBooksByName(String name) {
     String query = "SELECT * FROM books WHERE name = ?";
     ArrayList<Book> books = new ArrayList<>();
     try (PreparedStatement statement = connection.prepareStatement(query)) {
         statement.setString(1, name);
         try (ResultSet resultSet = statement.executeQuery()) {
             while (resultSet.next()) {
                 String subject = resultSet.getString("subject");
                 String publisher = resultSet.getString("publisher");
                 Date publicationDate = resultSet.getDate("publicationDate");
                 Language lang = Language.valueOf(resultSet.getString("language"));
                 double isbn = resultSet.getDouble("isbn");
                 Book book = new Book(name, subject, publisher, publicationDate, lang, 865);
                 books.add(book);
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return books;
 }
 public static void main(String[] args) {
    UserDAO userDAO = new UserDAO();
    // Select all users
  
    
  //Select users with a given name
   /*User user1 = new User("FRANCO", null, null);
   ArrayList<User> usersWithNamePETER = userDAO.selectBYNOME(user1);
   for (User user : usersWithNamePETER) {
       System.out.println(user);
   }*/
   
// Insert a new user
   /*User u = new User("NASSAR", "ABDOUL", "Via EREDI 1");
   UserDAO userDao = new UserDAO();
   boolean inserted = userDao.insertUser(u);
   if (inserted) {
       System.out.println("Utente inserito correttamente.");
   } else {
       System.out.println("Errore durante l'inserimento dell'utente.");
   }*/

  
 }

@Override
public String cerca() {
	
	return null;
}

@Override
public boolean availability() {
	
	return false;
}


 }



