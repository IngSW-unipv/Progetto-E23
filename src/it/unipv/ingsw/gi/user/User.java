package it.unipv.ingsw.gi.user;

public class User {
	private String NOME;
	private String COGNOME;
	private String indirizzo;
	
	
	public User(String NOME, String COGNOME,String Indirizzo) {
		this.NOME = NOME;
		this.COGNOME = COGNOME;
		this.indirizzo = Indirizzo;
	}
		public String getCognome() {
			return COGNOME;
		}
		
		public String getNome() {
			return NOME;
		}
		public String getIndirizzo() {
			return indirizzo;
		}
		
		public String toString() {
			// TODO Auto-generated method stub
			return "Fornitore ("+NOME+", "+COGNOME+", "+indirizzo+")";
		}
}

