package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class CancGUI extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancGUI window = new CancGUI();
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
	public CancGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cancella Prenotazione");
		btnNewButton.setBounds(21, 36, 140, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancellaLibro = new JButton("Cancella Libro");
		btnCancellaLibro.setBounds(269, 36, 140, 75);
		frame.getContentPane().add(btnCancellaLibro);
		
		JButton btnCancellaPatrono = new JButton("Cancella Patrono");
		btnCancellaPatrono.setBounds(146, 160, 140, 75);
		frame.getContentPane().add(btnCancellaPatrono);
	}

}
