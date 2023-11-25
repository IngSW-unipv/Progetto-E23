package it.unipv.ingsw.gi.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.admingui.AdminGUI;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.dao.AdminDAO;
import it.unipv.ingsw.gi.dao.BibDAO;
import it.unipv.ingsw.gi.dao.PatronoDAO;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.service.BibServices;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;


public class LogGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userIdTextField;
	private JPasswordField passwordField;


	/**
	 * Create the application.
	 */
	public LogGUI() {
	
		//fram title and layout
		new JFrame();
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		//labels
		JLabel UserID = new JLabel("UserID");
		UserID.setBounds(27, 31, 108, 27);
		getContentPane().add(UserID);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(27, 69, 108, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Biblioteca");
		lblNewLabel_2.setBounds(27, 212, 71, 14);
		getContentPane().add(lblNewLabel_2);

		
		//test field for user id input
		userIdTextField = new JTextField();
		userIdTextField.setBounds(136, 34, 148, 20);
		getContentPane().add(userIdTextField);
		userIdTextField.setColumns(10);

		// radio buttons for different types on users
		JRadioButton patronRadioButton = new JRadioButton("Patrono");
		patronRadioButton.setSelected(true);
		patronRadioButton.setBounds(26, 136, 109, 23);
		getContentPane().add(patronRadioButton);

		JRadioButton adminRadioButton = new JRadioButton("Admin");
		adminRadioButton.setBounds(136, 136, 109, 23);
		getContentPane().add(adminRadioButton);

		
		//button group for previous radio buttons
		ButtonGroup logbuttonGroup = new ButtonGroup();
		logbuttonGroup.add(patronRadioButton);
		logbuttonGroup.add(adminRadioButton);


		//box for library selection 
		JComboBox<Biblioteca> bibComboBox = new JComboBox<Biblioteca>();
		bibComboBox.setBounds(108, 208, 119, 22);
		getContentPane().add(bibComboBox);


		PatronoDAO pat= new PatronoDAO();
		BibDAO bibd = new BibDAO();
		AdminDAO ad = new AdminDAO();
		BibServices serv = new BibServices(pat,bibd,ad);
		ArrayList<Patrono> patrons = new ArrayList<>();
		ArrayList<Admin> admins = new ArrayList<>();
		ArrayList<PrendeInPrestito> books = new ArrayList<>();
		ArrayList<Libro> avaiBooks = new ArrayList<>();
		Biblioteca bib1 = new Biblioteca (books, "bib1", patrons, admins,avaiBooks);

		//filling the library with corresponding data
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


		//button for the login function
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
		getContentPane().add(btnNewButton);

		



		passwordField = new JPasswordField();
		passwordField.setBounds(136, 72, 148, 20);
		getContentPane().add(passwordField);
	}






}







