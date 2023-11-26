package it.unipv.ingsw.gi.admingui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.books.Lang;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.controllers.AdminController;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgguingiLibroGUI extends JFrame{

	/**
	 * 
	 */

	// declaring the needed components
	private static final long serialVersionUID = 1L;
	private Biblioteca recvdBib;
	private Admin recvdAdmn;
	private JTextField titoloField;
	private JTextField autoreField;
	private JTextField prezzoField;
	private JTextField libroIDField;
	protected AdminController admc = new AdminController(recvdAdmn);

	/**
	 * Create the application.
	 */
	public AgguingiLibroGUI(Biblioteca recvBib,Admin rec) {
		this.recvdBib = recvBib;
		this.recvdAdmn = rec;
		getContentPane().setLayout(null);

		// setting the characteristics of the components
		titoloField = new JTextField();
		titoloField.setBounds(10, 42, 222, 20);
		getContentPane().add(titoloField);
		titoloField.setColumns(10);

		autoreField = new JTextField();
		autoreField.setBounds(10, 73, 222, 20);
		getContentPane().add(autoreField);
		autoreField.setColumns(10);

		prezzoField = new JTextField();
		prezzoField.setBounds(10, 104, 222, 20);
		getContentPane().add(prezzoField);
		prezzoField.setColumns(10);

		libroIDField = new JTextField();
		libroIDField.setBounds(10, 11, 222, 20);
		getContentPane().add(libroIDField);
		libroIDField.setColumns(10);

		// creating and defining the labels 
		JLabel lblNewLabel = new JLabel("bookID");
		lblNewLabel.setBounds(242, 14, 70, 17);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("titolo");
		lblNewLabel_1.setBounds(242, 45, 70, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("autore");
		lblNewLabel_2.setBounds(242, 76, 89, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("prezzo");
		lblNewLabel_3.setBounds(242, 107, 70, 17);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("lingua");
		lblNewLabel_4.setBounds(242, 138, 70, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel stateLabel = new JLabel("Disponibilità");
		stateLabel.setBounds(240, 216, 72, 19);
		getContentPane().add(stateLabel);



		// list to hold the possible languages 
		JList<Lang> langListt = new JList<Lang>();
		langListt.setBounds(10, 137, 222, 68);
		ArrayList<Lang> langList = new ArrayList<>();
		DefaultListModel<Lang> listModel = new DefaultListModel<Lang>();
		langListt.setModel(listModel);
		langList.add(Lang.English);
		langList.add(Lang.French);
		langList.add(Lang.Italian);
		langList.add(Lang.German);
		langList.add(Lang.Spanish);

		for(Lang language : langList) {
			listModel.addElement(language);
		}
		getContentPane().add(langListt);



		// list to hold the possible states 
		JList<Boolean> dispList = new JList<Boolean>();
		dispList.setBounds(10, 215, 222, 35);
		ArrayList<Boolean> dissList = new ArrayList<>();
		DefaultListModel<Boolean> listModel2 = new DefaultListModel<Boolean>();
		dispList.setModel(listModel2);
		dissList.add(true);
		dissList.add(false);
		for(Boolean bo : dissList) {
			listModel2.addElement(bo); 
		}
		getContentPane().add(dispList);



		// button to call the add book function
		JButton btnNewButton = new JButton("Agguingi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int bookid = Integer.parseInt(libroIDField.getText());
				Double bookSaldo = Double.parseDouble(prezzoField.getText());
				Libro lib = new Libro(bookid,titoloField.getText(), autoreField.getText(),(Boolean) dispList.getSelectedValue(),(Lang) langListt.getSelectedValue(), bookSaldo);

				try {
					admc.addbookButtonClick(lib, recvdBib, recvdAdmn);
					JOptionPane.showMessageDialog(AgguingiLibroGUI.this, "book added!");
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(335, 212, 89, 23);
		getContentPane().add(btnNewButton);



	}
}
