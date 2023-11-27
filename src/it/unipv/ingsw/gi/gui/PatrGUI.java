package it.unipv.ingsw.gi.gui;


import javax.swing.JFrame;

import it.unipv.ingsw.gi.controllers.PatronoController;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.posti.PrenotaPosti;
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
	protected PatronoController pc = new PatronoController(recvpat);

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
				PipGUI newpip =	new PipGUI(PatrGUI.this.recvedbib,recvpat,pc);
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
		
		JButton PrenotaPostoStudio = new JButton("Prenota Posto");
		PrenotaPostoStudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrenotaPosti ps = new PrenotaPosti(10);
				PrenotaPostoGUI psg = new PrenotaPostoGUI(ps);
				psg.setSize(500,400);
				psg.setVisible(true);
			}
		});
		PrenotaPostoStudio.setBounds(10, 105, 134, 23);
		getContentPane().add(PrenotaPostoStudio);
		
		JButton VispostButton = new JButton("visualizza posti");
		VispostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizzaPostoGUI vsg = new VisualizzaPostoGUI();
				vsg.setSize(500,400);
				vsg.setVisible(true);
			}
		});
		VispostButton.setBounds(154, 105, 134, 23);
		getContentPane().add(VispostButton);

	}
}
