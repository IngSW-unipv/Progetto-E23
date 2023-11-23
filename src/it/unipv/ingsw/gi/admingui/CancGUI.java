package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancGUI extends JFrame{
	private Biblioteca recvdBib;
	private Admin recvdadmn;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancGUI window = new CancGUI(null,null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CancGUI(Biblioteca recvBib,Admin recvdadmn) {
		setTitle("cancel selection");
		this.recvdadmn= recvdadmn;
		this.recvdBib = recvBib;
		
		new JFrame();
		setBounds(100, 100, 469, 309);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cancella Prenotazione");
		btnNewButton.setBounds(120, 105, 164, 62);
		getContentPane().add(btnNewButton);
		
		JButton btnCancellaLibro = new JButton("Cancella Libro");
		btnCancellaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancellaLibroGUI clg = new CancellaLibroGUI(recvBib, recvdadmn);
				clg.setSize(500,400);
				clg.setVisible(true);
			}
		});
		btnCancellaLibro.setBounds(118, 178, 166, 62);
		getContentPane().add(btnCancellaLibro);
		
		JButton btnCancellaPatrono = new JButton("Cancella Patrono");
		btnCancellaPatrono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancPatGUI cpg = new cancPatGUI(recvBib, recvdadmn);
				cpg.setSize(500,400);
				cpg.setVisible(true);
			}
		});
		btnCancellaPatrono.setBounds(120, 26, 164, 68);
		getContentPane().add(btnCancellaPatrono);
	
	}

	

}
