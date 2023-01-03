package it.unipv.insw.gi.librarian;

public class User {
	private String nome;
	private String cognome;
	private String indirizzo;
	public User(String unNome, String unCognome,String unIndirizzo) {
		nome = unNome;
		cognome = unCognome;
		indirizzo = unIndirizzo;
	}
		public String getCognome() {
			return cognome;
		}
		
		public String getNome() {
			return nome;
		}
		public String getIndirizzo() {
			return indirizzo;
		}
	}


