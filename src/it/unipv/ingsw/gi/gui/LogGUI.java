package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import it.unipv.ingsw.gi.dbase.MyDbaseconnect;
import java.sql.*;

public class LogGUI extends JFrame{

	private JFrame frmLogin;
	private JTextField userIdTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogGUI window = new LogGUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel UserID = new JLabel("UserID");
		UserID.setBounds(27, 31, 108, 27);
		frmLogin.getContentPane().add(UserID);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(27, 69, 108, 27);
		frmLogin.getContentPane().add(lblNewLabel_1);

		userIdTextField = new JTextField();
		userIdTextField.setBounds(136, 34, 148, 20);
		frmLogin.getContentPane().add(userIdTextField);
		userIdTextField.setColumns(10);

		JRadioButton patronRadioButton = new JRadioButton("Patrono");
		patronRadioButton.setSelected(true);
		patronRadioButton.setBounds(26, 136, 109, 23);
		frmLogin.getContentPane().add(patronRadioButton);

		JRadioButton adminRadioButton = new JRadioButton("Admin");
		adminRadioButton.setBounds(136, 136, 109, 23);
		frmLogin.getContentPane().add(adminRadioButton);


		ButtonGroup logbuttonGroup = new ButtonGroup();
		logbuttonGroup.add(patronRadioButton);
		logbuttonGroup.add(adminRadioButton);






		JComboBox<Biblioteca> bibComboBox = new JComboBox<Biblioteca>();


		bibComboBox.setBounds(108, 208, 119, 22);
		frmLogin.getContentPane().add(bibComboBox);


		PatronoDAO pat= new PatronoDAO();
		BibDAO bibd = new BibDAO();
		AdminDAO ad = new AdminDAO();



		BibServices serv = new BibServices(pat,bibd,ad);



		ArrayList<Patrono> patrons = new ArrayList<>();
		ArrayList<Admin> admins = new ArrayList<>();
		ArrayList<PrendeInPrestito> books = new ArrayList<>();
		ArrayList<Libro> avaiBooks = new ArrayList<>();
		Biblioteca bib1 = new Biblioteca (books, "bib1", patrons, admins,avaiBooks);


		serv.serRecAdm(bib1);


		serv.servRecPat(bib1);


		serv.servRecLib(bib1);


		Biblioteca[] bibOptions = {

				bib1

		}; 

		DefaultComboBoxModel<Biblioteca> model = new DefaultComboBoxModel<Biblioteca>();
		model.addElement(bib1);
		bibComboBox.setModel(model);

		bibComboBox = new JComboBox<Biblioteca>(bibOptions);

		Biblioteca bibselect =(Biblioteca) bibComboBox.getSelectedItem() ;





		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int username = Integer.parseInt(userIdTextField.getText());
				char[] password = passwordField.getPassword();
				String userType = bibselect.authenticate(username, new String(password));
				
				
				
				
				Patrono selectedPatrono = null ;
				for (Patrono patrono : bibselect.patrons) {
					if (patrono.getPatronID() == username) {
						selectedPatrono = patrono;
						break; 
					}
				}
				
				
				

				Admin selectedAdmin = null;
				for(Admin admin : bibselect.admins) {
					if(admin.getAdminID() == username) {
						selectedAdmin = admin;
						break;
					}
				}



				if (userType.equals("User")) {
					JOptionPane.showMessageDialog(LogGUI.this, "Welcome, User!");
					PatrGUI Patrgui = new PatrGUI(bibselect,selectedPatrono);

					Patrgui.setSize(500, 400);
					Patrgui.setVisible(true);


				} else if (userType.equals("Admin")) {
					JOptionPane.showMessageDialog(LogGUI.this, "Welcome, Admin!");
					AdminGUI admgui =new AdminGUI(bibselect,selectedAdmin);
					
					admgui.setSize(500,400);
					admgui.setVisible(true);


				} else {
					JOptionPane.showMessageDialog(LogGUI.this, "Invalid username or password.");
				}


			}

		});



		btnNewButton.setBounds(292, 136, 108, 40);
		frmLogin.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Biblioteca");
		lblNewLabel_2.setBounds(27, 212, 71, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);



		passwordField = new JPasswordField();
		passwordField.setBounds(136, 72, 148, 20);
		frmLogin.getContentPane().add(passwordField);
	}






}







