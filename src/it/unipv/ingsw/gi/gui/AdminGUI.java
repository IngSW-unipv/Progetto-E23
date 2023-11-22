package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JFrame{

	private JFrame frame;
	protected Admin recvedadm;
	protected Biblioteca recvedbib;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI(null,null);
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
	public AdminGUI(Biblioteca bibselect,Admin recevadm) {
		this.recvedadm = recevadm;
		this.recvedbib = bibselect;
		
		setTitle("Admin interface");
		getContentPane().setLayout(null);

		JButton prenINPres = new JButton("Prendi In Prestito");
		prenINPres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prenINPres.setBounds(10, 46, 115, 23);
		getContentPane().add(prenINPres);

		JButton Aquista = new JButton("Aquista");
		Aquista.setBounds(10, 83, 115, 23);
		getContentPane().add(Aquista);

		JButton AddElement = new JButton("Agguingi");
		AddElement.setBounds(10, 117, 115, 23);
		getContentPane().add(AddElement);

		JButton deleteElement = new JButton("Cancella");
		deleteElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteElement.setBounds(10, 151, 115, 23);
		getContentPane().add(deleteElement);

		JButton stateMod = new JButton("Cambia Stato");
		stateMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiaStatoGUI cSGgui = new CambiaStatoGUI(bibselect,recevadm);
				cSGgui.setVisible(true);
				cSGgui.setSize(500, 400);
				
			}
		});
		stateMod.setBounds(10, 185, 115, 23);
		getContentPane().add(stateMod);

		JButton btnNewButton = new JButton("Restituire Libro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestitLibGUI risgui = new RestitLibGUI(bibselect,recevadm); 

				risgui.setSize(500, 400);
				risgui.setVisible(true);

			}
		});
		btnNewButton.setBounds(135, 46, 130, 23);
		getContentPane().add(btnNewButton);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}