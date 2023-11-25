package it.unipv.ingsw.gi.admingui;


import javax.swing.JFrame;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Biblioteca recvdbib;
	private Admin recvdadmn;




	/**
	 * Create the application.
	 */
	public AggGUI(Biblioteca recdbib,Admin recdAdmin) {
		this.recvdadmn= recdAdmin;
		this.recvdbib=recdbib;

		//absolute
		getContentPane().setLayout(null);


		//button to open the add book function
		JButton aggLibButton = new JButton("Agguingi Libro");
		aggLibButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AgguingiLibroGUI al = new AgguingiLibroGUI(recvdbib,recvdadmn);
				al.setSize(500,400);
				al.setVisible(true);

			}
		});
		aggLibButton.setBounds(30, 95, 140, 55);
		getContentPane().add(aggLibButton);


		//button to open the add patron function
		JButton aggPatButton = new JButton("Agguingi Patrono");
		aggPatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgguingiPatronoGUI ap = new AgguingiPatronoGUI(recvdbib,recvdadmn);
				ap.setSize(500,400);
				ap.setVisible(true);
			}
		});
		aggPatButton.setBounds(242, 95, 140, 55);
		getContentPane().add(aggPatButton);

	}


}
