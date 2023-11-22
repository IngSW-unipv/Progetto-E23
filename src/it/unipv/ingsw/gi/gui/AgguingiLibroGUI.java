package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class AgguingiLibroGUI extends JFrame{

	private JFrame frame;
	private JTextField titolo;
	private JTextField autore;
	private JTextField prezzo;
	private JTextField libroID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgguingiLibroGUI window = new AgguingiLibroGUI();
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
	public AgguingiLibroGUI() {
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
		
		titolo = new JTextField();
		titolo.setBounds(10, 42, 222, 20);
		frame.getContentPane().add(titolo);
		titolo.setColumns(10);
		
		autore = new JTextField();
		autore.setBounds(10, 73, 222, 20);
		frame.getContentPane().add(autore);
		autore.setColumns(10);
		
		prezzo = new JTextField();
		prezzo.setBounds(10, 104, 222, 20);
		frame.getContentPane().add(prezzo);
		prezzo.setColumns(10);
		
		libroID = new JTextField();
		libroID.setBounds(10, 11, 222, 20);
		frame.getContentPane().add(libroID);
		libroID.setColumns(10);
		
		JButton btnNewButton = new JButton("Agguingi");
		btnNewButton.setBounds(335, 212, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Disponibilità");
		chckbxNewCheckBox.setBounds(10, 212, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("bookID");
		lblNewLabel.setBounds(242, 14, 34, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("titolo");
		lblNewLabel_1.setBounds(242, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("autore");
		lblNewLabel_2.setBounds(242, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("prezzo");
		lblNewLabel_3.setBounds(242, 107, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("lingua");
		lblNewLabel_4.setBounds(242, 138, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JList list = new JList();
		list.setBounds(10, 137, 222, 68);
		frame.getContentPane().add(list);
	}
}
