package it.unipv.insw.gi.librarian;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.unipv.ingsw.gi.account.Account;
import it.unipv.ingsw.gi.account.AccountState;
import it.unipv.ingsw.gi.books.Book;
import it.unipv.ingsw.gi.books.Language;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.user.User;

public class LibrarianDAO implements manage {
	
	private Connection connection;

    public LibrarianDAO() {
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
    
    

	
@Override	
	public List<Account> selectAll1() {
		 List<Account> accounts = new ArrayList<>();
	        String query = "SELECT * FROM account";
	        try (Connection conn = MyDbaseconnect.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                double id = rs.getDouble("id");
	                Date openDate = rs.getDate("openDate");
	                AccountState state = AccountState.valueOf(rs.getString("state"));
	                Account account = new Account(id, openDate, new ArrayList<>(), state, new LinkedList<>());
	                accounts.add(account);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return accounts;
	    }	

	public void addAccount(Account account) throws SQLException {
		Connection con = MyDbaseconnect.getConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO account (id, opendate, state) VALUES (?, ?, ?)");
		ps.setDouble(1, account.getId());
		ps.setDate(2, new java.sql.Date(account.getOPENDATE().getTime()));
		ps.setString(3, account.getState().toString());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}

	public Account selectById(double id) {
		Account account = null;
        String query = "SELECT * FROM account WHERE id = ?";
        try (Connection conn = MyDbaseconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Date openDate = rs.getDate("openDate");
                AccountState state = AccountState.valueOf(rs.getString("state"));
                account = new Account(id, openDate, new ArrayList<>(), state, new LinkedList<>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
	
	public Account selectByOpenDate(Date openDate) {
        Account account = null;
        String query = "SELECT * FROM account WHERE openDate = ?";
        try (Connection conn = MyDbaseconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, openDate);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double id = rs.getDouble("id");
                AccountState state = AccountState.valueOf(rs.getString("state"));
	}

        } catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
    public ArrayList<User> selectAll() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Connection conn = MyDbaseconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("NOME");
                String cognome = rs.getString("COGNOME");
                String indirizzo = rs.getString("indirizzo");
                User user = new User(nome, cognome, indirizzo);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public ArrayList<User> selectBYNOME(User usInput) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user WHERE NOME=?";
        try (Connection conn = MyDbaseconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usInput.getNome());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("NOME");
                String cognome = rs.getString("COGNOME");
                String indirizzo = rs.getString("indirizzo");
                User user = new User(nome, cognome, indirizzo);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean insertUser(User U) {
        boolean inserted = false;
        String query = "INSERT INTO user(NOME, COGNOME, indirizzo) VALUES (?, ?, ?)";
        try (Connection conn = MyDbaseconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, U.getNome());
            stmt.setString(2, U.getCognome());
            stmt.setString(3, U.getIndirizzo());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                inserted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

}

	

