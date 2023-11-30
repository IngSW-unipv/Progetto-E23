package it.unipv.ingsw.gi.admingui;


import javax.swing.JFrame;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// variables passed from the previous window
	protected Admin recvedadm;
	private Biblioteca recvedbib;


	//creating the app
	public AdminGUI(Biblioteca bibselect,Admin recevadm) {
		this.recvedadm = recevadm;
		this.recvedbib = bibselect;

		// setting the title and setting the absolute layout
		setTitle("Admin interface");
		getContentPane().setLayout(null);



		//button that opens the borrow function interface
		JButton prenINPres = new JButton("Prendi In Prestito");
		prenINPres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminpipGUI apip = new  AdminpipGUI(bibselect, recevadm);
				apip.setSize(500,400);
				apip.setVisible(true);
			}
		});
		prenINPres.setBounds(10, 46, 163, 35);
		getContentPane().add(prenINPres);

		//button that opens the buy interface
		JButton Aquista = new JButton("Aquista");
		Aquista.setBounds(10, 102, 163, 35);
		getContentPane().add(Aquista);

		//button that opens the add interface for the books and patrons
		JButton AddElement = new JButton("Agguingi");
		AddElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggGUI agg = new AggGUI(bibselect,recevadm);

				agg.setSize(500,400);
				agg.setVisible(true);
			}
		});
		AddElement.setBounds(261, 102, 163, 35);
		getContentPane().add(AddElement);

		//button that opens the delete interface for books and patrons
		JButton deleteElement = new JButton("Cancella");
		deleteElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancGUI cg = new CancGUI(recvedbib,recvedadm);
				cg.setSize(500,400);
				cg.setVisible(true);
			}
		});
		deleteElement.setBounds(10, 163, 163, 35);
		getContentPane().add(deleteElement);

		//button that opens the state modifier interface
		JButton stateMod = new JButton("Cambia Stato");
		stateMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiaStatoGUI cSGgui = new CambiaStatoGUI(bibselect,recevadm);
				cSGgui.setVisible(true);
				cSGgui.setSize(500, 400);

			}
		});
		stateMod.setBounds(261, 163, 163, 35);
		getContentPane().add(stateMod);

		//button that opens the return function interface
		JButton btnNewButton = new JButton("Restituire Libro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestitLibGUI risgui = new RestitLibGUI(bibselect,recevadm); 

				risgui.setSize(500, 400);
				risgui.setVisible(true);

			}
		});
		btnNewButton.setBounds(261, 46, 163, 35);
		getContentPane().add(btnNewButton);

	}


}
