package it.unipv.ingsw.gi.patrongui;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcquistareGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;


	/**
	 * Create the application.
	 */
	public AcquistareGUI() {
		
		new JFrame();
		setTitle("Acquistare");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 304, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JList<Object> list = new JList<Object>();
		list.setBounds(10, 56, 304, 75);
		getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(324, 63, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(324, 97, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(324, 24, 89, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Agguingi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(324, 131, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 162, 108);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton_3 = new JButton("Prosegui");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton_3);
	}
	
	
}
