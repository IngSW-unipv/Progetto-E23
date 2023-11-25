package it.unipv.ingsw.gi.tests;

import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class prenotaTest {
	
	public static void main(String []args) {
		
		// creazione di un istanza di prenotazione con 10 posti studio
					PrenotaPosti prenotazione = new PrenotaPosti(5);
					//prenotazione.visualizzaPostiDisponibili();
					
					Patrono p1 = new Patrono(0, "test", null, null, null, 0);
					Patrono p2 = new Patrono(0, null, "test2", null, null, 0);
					//Patrono p3 = new Patrono("karl","pause5","mama");
					Admin A1 = new Admin(0, null, null);
					//Admin A2 = new Admin("salade","tomate","concombre");
					//Admin A3 = new Admin("pomodoro","courgette","blanc");
					prenotazione.visualizzaPostiDisponibili();
					prenotazione.prenotaPosto(p1, 1, 60);
					prenotazione.prenotaPosto(p1, 2, 40);
					prenotazione.prenotaPosto(p2, 2, 20);
					prenotazione.cancellaPrenotazione(A1,1);
					//prenotazione.visualizzaPostiDisponibili();
					//prenotazione.prenotaPosto(p3, 2, 30);
					//prenotazione.cancellaPrenotazione(A2, 2);
					//prenotazione.visualizzaPostiDisponibili();
					
		
	}
	
	

}





