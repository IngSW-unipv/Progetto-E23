package it.unipv.ingsw.gi.gui;
//gestire gli oggetti della swing.
import javax.swing.*;

import it.unipv.ingsw.gi.posti.PrenotaPosti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VisualizzaPostoGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea risultatiArea;
	
	
  
	// costruttore della classe.
	public VisualizzaPostoGUI() {
		
		// chiamata al costruttore della classe madre JFrame con titolo PrenotazionePostoStudio
		super("Prenotazione Posti Studio");
		
		
		/// inizializzazione di un istanza di PrenotazionePostoStudio con 20 posti.
		PrenotaPosti prenotazione = new PrenotaPosti(10);
		
		// creazione del pulsante posti disponibili
		JButton visualizzaButton = new JButton(" Posti Disponibili");
		
		
		// impostazione di un area di testo, impostata come non edibile
		risultatiArea = new JTextArea(10,30);
		risultatiArea.setEditable(false);
		
		// creazione di un pannello per contenere il pulsante 'posti disponibili'
		JPanel inputPanel = new JPanel();
		inputPanel.add(visualizzaButton);
		
		// aggiunta del panello degli input (inputpanel) nella parte superiore del frame
		getContentPane().add(inputPanel,"North");
		
		// aggiunta di un area di risultato nella parte all'interno di una Jscrollpane  nella parte centrale del frame
		getContentPane().add(new JScrollPane(risultatiArea), "Center");
		
		// aggiunta di un actionlistener al pulsante 
		visualizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// chiamata al metodo visualizzaPostiDisponibili.
				prenotazione.visualizzaPostiDisponibili();
				
				// chiamata al metodo passando l'area di testo risultatiArea
				prenotazione.visualizzaPostiDisponibili(risultatiArea);
				
				// impostazione del testo del area di testo con il risultato del metodo.
				risultatiArea.setText("Posti disponibili:\n" + prenotazione.getPostiDisponibiliAsString());

			}
		});

	        // Impostazioni per il frame
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        pack();
	        setLocationRelativeTo(null); // Posiziona al centro dello schermo
	        setVisible(true);
	    }
// metodo principale per l'esecuzione dell'applicazione Swing.
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	            	// creazione di un istanza della classe.
	                new VisualizzaPostoGUI();
	            }
	        });
	    }
	
		
	}
	

	