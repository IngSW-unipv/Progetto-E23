package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class cancPatGUI extends JFrame{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancPatGUI window = new cancPatGUI();
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
	public cancPatGUI() {
		setTitle("Cancella Patrono");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 267, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.setBounds(283, 26, 89, 23);
		getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(10, 72, 267, 36);
		getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Cancella");
		btnNewButton_1.setBounds(335, 198, 89, 23);
		getContentPane().add(btnNewButton_1);
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
