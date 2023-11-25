package it.unipv.ingsw.gi.gui;


import javax.swing.JFrame;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatrGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Biblioteca recvedbib;
	protected Patrono recvpat;


	/**
	 * Create the application.
	 */
	public PatrGUI(Biblioteca recvedbib ,Patrono recvpat) {
		this.recvedbib = recvedbib;
		this.recvpat = recvpat;

		//title and layout
		setTitle("Patrono ");
		getContentPane().setLayout(null);

		//button for borrow method
		JButton btnNewButton = new JButton("Prendi in prestito");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PipGUI newpip =	new PipGUI(PatrGUI.this.recvedbib,recvpat);
				newpip.setVisible(true);
				newpip.setSize(500, 400);
			}
		});
		btnNewButton.setBounds(10, 71, 134, 23);
		getContentPane().add(btnNewButton);

		//button for buy method 
		JButton acquistaButton = new JButton("Aquista");
		acquistaButton.setBounds(154, 71, 134, 23);
		getContentPane().add(acquistaButton);

		//button for search method 
		JButton cercaButton = new JButton("Cerca Libro");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RicercaGUI rg = new RicercaGUI(recvedbib, recvpat);
				rg.setSize(500,400);
				rg.setVisible(true);
			}
		});
		cercaButton.setBounds(298, 71, 126, 23);
		getContentPane().add(cercaButton);

	}


}
