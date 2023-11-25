package it.unipv.ingsw.gi.admingui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;

public class CancellaLibroGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Biblioteca recvedbib;
	private JTextField booksearchfield;
	protected Admin recvedadm;



	/**
	 * Create the application.
	 */
	public CancellaLibroGUI(Biblioteca biblioteca,Admin recvAdmin) {
		this.recvedbib = biblioteca;
		this.recvedadm = recvAdmin;

		// title and layout
		setTitle("Cancella Libro");
		getContentPane().setLayout(null);

		// search bar for books
		booksearchfield = new JTextField();
		booksearchfield.setBounds(10, 11, 292, 20);
		getContentPane().add(booksearchfield);
		booksearchfield.setColumns(10);


		//list to hold the results of the search
		JList<Libro> bookresultslist = new JList<Libro>();
		bookresultslist.setBounds(10, 47, 292, 105);
		getContentPane().add(bookresultslist);
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		bookresultslist.setModel(listModel);


		// button to call the search method for books
		JButton libsearchbutton = new JButton("cerca");
		libsearchbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.clear();
				RicercaperID rpd = new RicercaperID();
				ArrayList<Libro> list = new ArrayList<>();
				for(Libro p : recvedbib.books) {
					list.add(p);
				}
				list = rpd.ricerca(list, Integer.parseInt(booksearchfield.getText()));

				for(Libro lib : list) {
					listModel.addElement(lib);
				}}
		});

		libsearchbutton.setBounds(312, 10, 89, 23);
		getContentPane().add(libsearchbutton);


		//button to clear the search bar
		JButton patclearbutton = new JButton("clear");
		patclearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booksearchfield.setText("");
			}
		});
		patclearbutton.setBounds(312, 44, 89, 23);
		getContentPane().add(patclearbutton);


		//button to call the delete method 
		JButton btnNewButton_3 = new JButton("Conferma");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					recvAdmin.canLibro((Libro) bookresultslist.getSelectedValue(), biblioteca);
					JOptionPane.showMessageDialog(CancellaLibroGUI.this, "book deleted!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_3.setBounds(312, 207, 100, 31);
		getContentPane().add(btnNewButton_3);

	}



}
