package it.unipv.ingsw.gi.books;
import it.unipv.insw.gi.librarian.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

import it.unipv.ingsw.gi.dbase.*;
import it.unipv.ingsw.gi.user.User;


public class BookDAO implements IBook {
	
	private Connection connection;

    public BookDAO() {
        connection = MyDbaseconnect.getConnection();
    }
@Override
    public boolean addBook(Book book) {
        String query = "INSERT INTO books (name, subject, publisher, publicationDate, language, isbn) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.name);
            statement.setString(2, book.subject);
            statement.setString(3, book.publisher);
            statement.setDate(4, new java.sql.Date(book.publicationDate.getTime()));
            statement.setString(5, book.lang.toString());
            statement.setDouble(6, book.ISBN);
            int rowsInserted = statement.executeUpdate();
            return (rowsInserted == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
@Override
    public boolean deleteBook(String isbn) {
        String query = "DELETE FROM books WHERE isbn = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, isbn);
            int rowsDeleted = statement.executeUpdate();
            return (rowsDeleted == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
@Override
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
@Override
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
    // Creazione di un oggetto BookDAO per interagire con il database
    BookDAO bookDAO = new BookDAO();
    
    // Aggiunta di un libro al database
  /* Book book = new Book("Il nome della rosa", "Giallo storico", "Adelphi", new Date(), Language.Italiano, 978834);
    boolean bookAdded = bookDAO.addBook(book);
    System.out.println("Libro aggiunto al database: " + bookAdded);*/
    
    
    
    // Ottenimento di tutti i libri dal database
  ArrayList<Book> books = bookDAO.getAllBooks();
    System.out.println("Lista dei libri nel database:");
    for (Book b : books) {
        System.out.println(b);
    }
    
    // Rimozione di un libro dal database
   /*String isbn = "978834";
    boolean bookDeleted = bookDAO.deleteBook(isbn);
    System.out.println("Libro rimosso dal database: " + bookDeleted);
    
    // Ottenimento di tutti i libri dal database dopo la rimozione
    books = bookDAO.getAllBooks();
    System.out.println("Lista dei libri nel database dopo la rimozione:");
    for (Book b : books) {
        System.out.println(b);
    }*/
    
    // Ottenimento di tutti i libri con un determinato nome dal database
   /* ArrayList<Book> book = bookDAO.getBooksByName("Das Parfum");
    String name = "Das Parfum"; 
    book = bookDAO.getBooksByName(name);
    System.out.println("Libri con nome " + name + " nel database:");
    for (Book b : book) {
        System.out.println(b);
    }*/
}






}
