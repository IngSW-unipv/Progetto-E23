package it.unipv.ingsw.gi.gui;

import javax.swing.*;

import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.users.Patrono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrenotaPostoGUI extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PrenotaPosti prenotazione;

	    private JTextField numeroPostoField;
	    private JTextField durataField;
	    private JButton prenotaButton;

	    public PrenotaPostoGUI(PrenotaPosti prenotazione) {
	        this.prenotazione = prenotazione;

	        // Impostazione del frame
	        setTitle("Prenotazione Posto");
	        setSize(300, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Creazione dei componenti
	        numeroPostoField = new JTextField(10);
	        durataField = new JTextField(10);
	        prenotaButton = new JButton("Prenota Posto");

	        // Aggiunta del listener al bottone
	        prenotaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                prenotaPosto();
	            }
	        });

	        // Creazione del layout
	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Numero Posto:"));
	        panel.add(numeroPostoField);
	        panel.add(new JLabel("Durata Prenotazione (minuti):"));
	        panel.add(durataField);
	        panel.add(prenotaButton);

	        // Aggiunta del pannello al frame
	        add(panel);

	        // Visualizzazione del frame
	        setVisible(true);
	    }

	    private void prenotaPosto() {
	        String numeroPostoStr = numeroPostoField.getText();
	        String durataStr = durataField.getText();

	        try {
	            int numeroPosto = Integer.parseInt(numeroPostoStr);
	            int durata = Integer.parseInt(durataStr);

	            Patrono patrono = new Patrono(numeroPosto, numeroPostoStr, durataStr, null, null, durata);
	            prenotazione.prenotaPosto(patrono, numeroPosto, durata);

	            // Visualizza un messaggio di successo
	            JOptionPane.showMessageDialog(this, "Prenotazione effettuata con successo da " + patrono.getName() + ".");
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Inserisci numeri validi.", "Errore", JOptionPane.ERROR_MESSAGE);
	        } catch (RuntimeException ex) {
	            // Se c'è un'eccezione durante la prenotazione, visualizza il messaggio corrispondente
	            JOptionPane.showMessageDialog(this, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public static void main(String[] args) {
	    	PrenotaPosti prenotazione = new PrenotaPosti(10);
	        SwingUtilities.invokeLater(() -> new PrenotaPostoGUI(prenotazione));
	    }
}

	
