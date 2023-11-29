package it.unipv.ingsw.gi.admingui;



import javax.swing.*;
import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.users.Admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
public class CancellaPrenotazionePostoGUI extends JFrame {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrenotaPosti prenotazione;
	    private JFrame frame;
	    private JTextArea risultatiArea;
	    private JTextField numeroPostoField;

	    public CancellaPrenotazionePostoGUI(PrenotaPosti prenotazione) {
	        this.prenotazione = prenotazione;
	        initialize();
	    }

	    private void initialize() {
	        frame = new JFrame("Cancella Prenotazione");
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	        JPanel mainPanel = new JPanel(new BorderLayout());

	        risultatiArea = new JTextArea(10, 30);
	        risultatiArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(risultatiArea);

	        mainPanel.add(scrollPane, BorderLayout.CENTER);

	        JPanel inputPanel = new JPanel();

	        // Aggiungi un campo di testo per il numero del posto
	        numeroPostoField = new JTextField(10);
	        inputPanel.add(numeroPostoField);

	        // Aggiungi il pulsante di cancellazione della prenotazione
	        JButton cancellaPrenotazioneButton = new JButton("Cancella Prenotazione");
	        inputPanel.add(cancellaPrenotazioneButton);

	        cancellaPrenotazioneButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String numeroPostoStr = numeroPostoField.getText();

	                try {
	                    int numeroPosto = Integer.parseInt(numeroPostoStr);
	                    // Chiamiamo il metodo cancellaPrenotazione e otteniamo il risultato
	                    prenotazione.cancellaPrenotazione(new Admin(22, "admin", "adminpass"), numeroPosto);
	                    // Aggiorniamo l'area dei risultati o facciamo altre operazioni necessarie
	                    risultatiArea.setText("Risultati dopo cancellazione:\n" + prenotazione.getPostiDisponibiliAsString());
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Inserisci un numero valido.", "Errore", JOptionPane.ERROR_MESSAGE);
	                }

	                // Controlliamo il risultato della cancellazione
	                if (prenotazione.getRisultatoCancellazione()) {
	                    // Se la cancellazione ha avuto successo
	                    JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.", "Risultato", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    // Se la cancellazione non ha avuto successo, mostriamo un messaggio adeguato
	                    JOptionPane.showMessageDialog(null, "Operazione non riuscita. Verifica il numero del posto e riprova.", "Errore", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        mainPanel.add(inputPanel, BorderLayout.SOUTH);

	        frame.getContentPane().add(mainPanel);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	    	PrenotaPosti prenotazione = new PrenotaPosti(10);
	        SwingUtilities.invokeLater(() -> new CancellaPrenotazionePostoGUI(prenotazione));
	    }
}
