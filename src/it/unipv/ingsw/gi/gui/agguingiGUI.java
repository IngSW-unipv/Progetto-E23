package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class agguingiGUI extends JFrame{

	private JFrame frmAgguingiInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agguingiGUI window = new agguingiGUI();
					window.frmAgguingiInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public agguingiGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgguingiInterface = new JFrame();
		frmAgguingiInterface.setTitle("Agguingi Interface");
		frmAgguingiInterface.setBounds(100, 100, 450, 300);
		frmAgguingiInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgguingiInterface.getContentPane().setLayout(null);
		
		JButton addLibro = new JButton("Agguingi Libro");
		addLibro.setBounds(35, 82, 150, 74);
		frmAgguingiInterface.getContentPane().add(addLibro);
		
		JButton addPatrono = new JButton("Agguingi Patrono");
		addPatrono.setBounds(225, 82, 150, 74);
		frmAgguingiInterface.getContentPane().add(addPatrono);
	}

}
