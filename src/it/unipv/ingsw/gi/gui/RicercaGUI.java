package it.unipv.ingsw.gi.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.controllers.SearchController;
import it.unipv.ingsw.gi.controllers.SearchControllerPerAutore;
import it.unipv.ingsw.gi.controllers.SearchControllerPerTitolo;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;

public class RicercaGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Biblioteca recvedbib;
	protected Patrono recvpat;




	/**
	 * Create the application.
	 */
	public RicercaGUI(Biblioteca recvdbib,Patrono recvdpat) {
		setTitle("Cerca ");
		this.recvedbib = recvdbib; 
		this.recvpat = recvdpat;


		new JFrame();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		//search bar for books
		JTextField searchbar = new JTextField();
		searchbar.setBounds(10, 11, 261, 20);
		getContentPane().add(searchbar);
		searchbar.setColumns(10);

		//box to choose the search strategy from 
		JComboBox<String> searchStrat = new JComboBox<String>();
		searchStrat.setModel(new DefaultComboBoxModel<String>(new String[] {"per autore", "per titolo"}));
		searchStrat.setBounds(281, 10, 143, 22);
		getContentPane().add(searchStrat);



		//list to hold the search strategy results
		JList<Libro> results = new JList<Libro>();
		results.setBounds(10, 42, 261, 188);
		getContentPane().add(results);
		ArrayList<Libro> resultList = new ArrayList<>();
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		results.setModel(listModel);
		for (Libro item : resultList) {
			listModel.addElement(item);
		}


		//button to call the search method 
		JButton btnNewButton_2 = new JButton("cerca");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				
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
				
						listModel.addElement(item);
				

				}


			}
		});



		btnNewButton_2.setBounds(281, 43, 89, 23);
		getContentPane().add(btnNewButton_2);


		//button to clear the search bar 
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbar.setText("");
				listModel.clear();
			}
		});
		btnNewButton_1.setBounds(335, 198, 89, 23);
		getContentPane().add(btnNewButton_1);


	}



}
