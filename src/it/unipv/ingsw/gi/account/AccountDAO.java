package it.unipv.ingsw.gi.account;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.unipv.ingsw.gi.books.Book;
import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import it.unipv.ingsw.gi.user.User;




public class AccountDAO implements IAccount {


	
@Override	
	public List<Account> selectAll() {
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
	


public static void main(String[] args) {
	

        User user = new User("BRICE", "Mario", "cremona 278");
        AccountDAO accountDAO = new AccountDAO();

     // Test createAccount()
    /*    Account account = new Account(48937, new Date(2011-8-05), null, AccountState.active, null);
        
        try {
            accountDAO.addAccount(account);
            System.out.println("Account added successfully");
        } catch (SQLException e) {
            System.out.println("Error while adding account: " + e.getMessage());
        }*/
    
        
        // Test selectAll()
       /* List<Account> accounts = accountDAO.selectAll();
        System.out.println("Accounts:");
        for (Account account : accounts) {
            System.out.println(account.toString());
        }*/
        
        // Test selectById()
       /* Account accountById = accountDAO.selectById(4758);
        System.out.println("Account by id: " + accountById.toString());*/
        
        

        // Test selectByOpenDate()
    /*    Account accountByOpenDate = accountDAO.selectByOpenDate(System.currentTimeMillis());
        System.out.println("Account by open date: " + accountByOpenDate.toString());
    }*/

    // crea un'istanza di AccountDAO

    // seleziona tutti gli account dal database e stampa i risultati
   /* List<Account> accounts = accountDAO.selectAll();
    System.out.println("Elenco account:");
    for (Account account : accounts) {
        System.out.println(account);
    }*/
    
   
   

    // seleziona un account dal database in base all'id e stampa il risultato
   double id = 1234;
    Account account = accountDAO.selectById(id);
    if (account != null) {
        System.out.println("Account selezionato per l'id " + id + ": " + account);
    } else {
        System.out.println("Nessun account trovato per l'id " + id);
    }



}

@Override
public boolean createAccount(User user) {
	// TODO Auto-generated method stub
	return false;
}

}






