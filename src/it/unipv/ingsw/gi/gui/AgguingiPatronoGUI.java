package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AgguingiPatronoGUI extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgguingiPatronoGUI window = new AgguingiPatronoGUI();
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
	public AgguingiPatronoGUI() {
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
		
		textField = new JTextField();
		textField.setBounds(10, 11, 193, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 42, 193, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 73, 193, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 104, 193, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel = new JLabel("userID");
		lblNewLabel.setBounds(213, 14, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUserpassword = new JLabel("User Password");
		lblUserpassword.setBounds(213, 45, 82, 14);
		frame.getContentPane().add(lblUserpassword);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(213, 76, 67, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblAccountState = new JLabel("Account State");
		lblAccountState.setBounds(213, 138, 89, 14);
		frame.getContentPane().add(lblAccountState);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(213, 107, 46, 14);
		frame.getContentPane().add(lblSaldo);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 135, 193, 49);
		frame.getContentPane().add(list);
	}
}
