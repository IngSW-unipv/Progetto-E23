package it.unipv.ingsw.gi.posti;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class PrenotazionePostoStudio {

	//private int numeroPosto;
		//private int durataPrenotazione;
		//private Patrono patrono;
		 
		
		
		//public  PrenotazionePostoStudio( int numeroPosto,int durataPrenotazione , Patrono patrono); {
			//this.numeroPosto = numeroPosto;
			//this.durataPrenotazione = durataPrenotazione;
			//this.patrono = patrono ;
		//}
		
		// mappa dei posti disponibili
		private Map<Integer,PostoStudio> postiStudio = new HashMap<>();
		//mappa dei prenotazioni fatte da patroni
		private Map<Patrono,Integer> prenotazioniPatrono = new HashMap<>();
		// mappa dei prenotazioni fatte da admin manuele
		private Map<Admin , Integer> prenotazioniAdmin = new HashMap<>();
		
		//costruttore della classe
		public PrenotazionePostoStudio(int numPosti) {
			for (int i = 1; i<= numPosti; i++) {
				postiStudio.put(i, new  PostoStudio());
				
			}
			
		}
		// metodo per visualizzare i posti disponibili
		public void visualizzaPostiDisponibili() {

		   System.out.println("Posti disponibili:");
			// per indicare l'elenco dei posti disponibili
			for (Map.Entry<Integer, PostoStudio> entry : postiStudio.entrySet()) {
				
			if(entry.getValue().isDisponibile()){
				System.out.println("Posto"+ entry.getKey());
				
				}
			}
		}
		
		  
		 
			  
		  
		
		// metodo per prenotare un posto per un determinato periodo di tempo
		
		public void prenotaPosto(Patrono patrono,int numeroPosto , int durataPrenotazione) {
			// verifica se il patrono ha già una prenotazione in corso
			if(!prenotazioniPatrono.containsKey(patrono)) {
			PostoStudio posto = postiStudio.get(numeroPosto);
			// verifica se il posto è valido e disponibile
			if (posto != null && posto.isDisponibile()) {
				posto.occupaPosto();
				System.out.println("Posto" +numeroPosto+ "prenotato per" +durataPrenotazione+ "minuti da" + patrono.getName()+".");
				// aggiungi la prenotazione alla mappa dei prenotazioni
				prenotazioniPatrono.put(patrono ,numeroPosto);
				
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					//@Override
					public void run() {
						posto.liberaPosto();
						System.out.println(" Posto"+ numeroPosto+ " liberato dopo "+ durataPrenotazione + "minuti.");
						timer.cancel();
					}
					
				}, durataPrenotazione*60*1000);
				
			}else {
				System.out.println("il posto" + numeroPosto + " non è disponibile");
				
			}
			visualizzaPostiDisponibili();
		}else {
			System.out.println(patrono.getName()+ " ha già una prenotazione in corso.");
		}
		}

		public void cancellaPrenotazione(Admin admin ,int numeroPosto) {
			if(prenotazioniPatrono.containsValue(numeroPosto)) {
			PostoStudio posto = postiStudio.get(numeroPosto);
			// se il posto è valido e occupato
			if (posto!= null && !posto.isDisponibile()) {
				posto.liberaPosto();
				System.out.println("Prenotazione del posto" +numeroPosto+ "cancella manualmente da"+ admin.getAdminName()+".");
				prenotazioniPatrono.remove(getPatronoByPosto(numeroPosto));
			} else {
				System.out.println("il posto" + numeroPosto+ " non è attualmente prenotato o non esiste");
			}
		} else {
			System.out.println("Nessuna prenotazione trovata per il posto" + numeroPosto + ".");
		}
		}
		private Patrono getPatronoByPosto(int numeroPosto) {
			for(Map.Entry<Patrono , Integer> entry : prenotazioniPatrono.entrySet()) {
				if (entry.getValue() == numeroPosto) {
					return entry.getKey();
					
				}
			}
			return null;
		}
		
		
	
	
	
}
