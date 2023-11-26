package it.unipv.ingsw.gi.admingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.controllers.SearchController;
import it.unipv.ingsw.gi.controllers.SearchControllerPerAutore;
import it.unipv.ingsw.gi.controllers.SearchControllerPerTitolo;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class AdminpipGui extends JFrame{
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	private Biblioteca recvedbib;
	private Admin recvdadmn;
	private JTextField patSearchbar;



	// creating the app
	public AdminpipGui(Biblioteca recvedbib,Admin recvadmn) {
		this.recvedbib = recvedbib;
		this.recvdadmn = recvadmn;


		// title and absolute layout
		setTitle("Prendi In Prestito (Admin)");
		getContentPane().setLayout(null);

		// book search bar 
		JTextField searchbar = new JTextField();
		searchbar.setBounds(10, 82, 261, 20);
		getContentPane().add(searchbar);
		searchbar.setColumns(10);

		// box to choose from the different search strategies
		JComboBox<String> searchStrat = new JComboBox<String>();
		searchStrat.setModel(new DefaultComboBoxModel<String>(new String[] {"per autore", "per titolo"}));
		searchStrat.setBounds(281, 81, 143, 22);
		getContentPane().add(searchStrat);



		// a list to show the results of the search 
		JList<Libro> results = new JList<Libro>();
		results.setBounds(10, 113, 261, 137);
		getContentPane().add(results);
		ArrayList<Libro> resultList = new ArrayList<>();
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		results.setModel(listModel);
		for (Libro item : resultList) {
			listModel.addElement(item);
		}


		// patron search bar 
		patSearchbar = new JTextField();
		patSearchbar.setBounds(10, 11, 261, 20);
		getContentPane().add(patSearchbar);
		patSearchbar.setColumns(10);


		// a list to show the results of the search 
		JList<Patrono> patList = new JList<Patrono>();
		patList.setBounds(10, 37, 261, 34);
		getContentPane().add(patList);
		DefaultListModel<Patrono> patlistModel = new DefaultListModel<Patrono>();
		patList.setModel(patlistModel);




		// a button to implement the search function for the patrons
		JButton cercapatButton = new JButton("Cerca");
		cercapatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				RicercaperID rpd = new RicercaperID();
				ArrayList<Patrono> list = new ArrayList<>();
				for(Patrono p : recvedbib.patrons) {
					list.add(p);
				}

				list = rpd.ricercaPat(list, Integer.parseInt(patSearchbar.getText()));

				for(Patrono pat : list) {
					patlistModel.addElement(pat);
				}}
		});
		cercapatButton.setBounds(281, 10, 89, 23);
		getContentPane().add(cercapatButton);



		// a button to implement the search function for book with the different strategies
		JButton btnNewButton_2 = new JButton("cerca");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchT = (String) searchStrat.getSelectedItem();
				String searchInput = searchbar.getText();
				SearchController<String> searchstrat2;
		
				if ("per titolo".equals(searchT)) {
					
					searchstrat2 = new SearchControllerPerTitolo();
				}
				else if ("per autore".equals(searchT)) {
					
					searchstrat2 = new SearchControllerPerAutore();

				} else {
					return;
				}
				ArrayList<Libro> risultati = (ArrayList<Libro>) searchstrat2.ricerca(recvedbib.books, searchInput);

				for (Libro item : risultati) {
					if(item.isAvailable == true) {
						listModel.addElement(item);
					}

				}


			}
		});
		btnNewButton_2.setBounds(281, 114, 89, 23);
		getContentPane().add(btnNewButton_2);



		// a button to implement the borrow function
		JButton btnNewButton = new JButton("conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//patron passed is the selection from the jlist same with the book is the one selected from the other list
				Patrono recvdpat = (Patrono) patList.getSelectedValue();
				Libro selectedObject = (Libro) results.getSelectedValue();
				if (selectedObject != null && recvdpat != null) {
					try {		
						recvdadmn.borrowbook(selectedObject, LocalDate.now(), recvdpat, AdminpipGui.this.recvedbib);	
						// pop up window for confirmation
						JOptionPane.showMessageDialog(AdminpipGui.this, "book borrowed succefully!");
						// clearing the list and listner
						listModel.clear();
						patlistModel.clear();
						selectedObject.addPropertyChangeListener(recvadmn);
						selectedObject.addPropertyChangeListener(recvdpat);

					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(335, 193, 89, 23);
		getContentPane().add(btnNewButton);


		// a button to clear the book search bar
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbar.setText("");

			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton_1);


		// a button to clear the patron result list 
		JButton clearListbutton = new JButton("clear");
		clearListbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patlistModel.clear();
			}
		});
		clearListbutton.setBounds(281, 37, 89, 23);
		getContentPane().add(clearListbutton);







	}




}
