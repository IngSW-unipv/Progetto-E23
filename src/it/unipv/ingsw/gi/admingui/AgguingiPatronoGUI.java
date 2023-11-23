package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AgguingiPatronoGUI extends JFrame{
	private Biblioteca recvdbib;
	private Admin recvdadmn;
	private JFrame frame;
	private JTextField userIDField;
	private JTextField userPassField;
	private JTextField usernameField;
	private JTextField saldoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgguingiPatronoGUI window = new AgguingiPatronoGUI(null,null);
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
	public AgguingiPatronoGUI(Biblioteca recvdbib,Admin recvdAdmn) {
		new JFrame();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		userIDField = new JTextField();
		userIDField.setBounds(10, 11, 193, 20);
		getContentPane().add(userIDField);
		userIDField.setColumns(10);

		userPassField = new JTextField();
		userPassField.setColumns(10);
		userPassField.setBounds(10, 42, 193, 20);
		getContentPane().add(userPassField);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(10, 73, 193, 20);
		getContentPane().add(usernameField);

		saldoField = new JTextField();
		saldoField.setColumns(10);
		saldoField.setBounds(10, 104, 193, 20);
		getContentPane().add(saldoField);

		JLabel lblNewLabel = new JLabel("userID");
		lblNewLabel.setBounds(213, 14, 82, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblUserpassword = new JLabel("User Password");
		lblUserpassword.setBounds(213, 45, 115, 14);
		getContentPane().add(lblUserpassword);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(213, 76, 115, 14);
		getContentPane().add(lblUserName);

		JLabel lblAccountState = new JLabel("Account State");
		lblAccountState.setBounds(213, 138, 115, 14);
		getContentPane().add(lblAccountState);

		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(213, 107, 46, 14);
		getContentPane().add(lblSaldo);



		JList<Stato> stateList = new JList<Stato>();

		ArrayList<Stato> stateListt= new ArrayList<>();
		DefaultListModel<Stato> listModel = new DefaultListModel<Stato>();
		stateList.setModel(listModel);

		stateListt.add(Stato.active);		
		stateListt.add(Stato.closed);
		stateListt.add(Stato.frozen);

		for(Stato stat : stateListt) {
			listModel.addElement(stat);
		}


		stateList.setBounds(10, 135, 193, 49);
		getContentPane().add(stateList);




		JButton agguingi = new JButton("Agguingi");
		agguingi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Libro> patlib = new ArrayList<>();
				Patrono recvdpat = new Patrono(Integer.parseInt(userIDField.getText()), userPassField.getText(), usernameField.getText(), patlib, stateList.getSelectedValue(), Double.parseDouble(saldoField.getText()));
				try {
					recvdAdmn.aggPatrono(recvdpat, recvdbib);
					System.out.println("patrono added succefully");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		agguingi.setBounds(335, 227, 89, 23);
		getContentPane().add(agguingi);

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

	}
}
