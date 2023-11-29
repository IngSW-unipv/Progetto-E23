package it.unipv.ingsw.gi.patrongui;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.controllers.PatronoController;
import it.unipv.ingsw.gi.controllers.SearchController;
import it.unipv.ingsw.gi.controllers.SearchControllerPerAutore;
import it.unipv.ingsw.gi.controllers.SearchControllerPerTitolo;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;


public class PipGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchbar;
	protected Biblioteca recvedbib;
	protected Patrono recvpat;
	protected PatronoController pc = new PatronoController(recvpat);


	/**
	 * Create the application.
	 */
	public PipGUI(Biblioteca recvedbib ,Patrono recvpat,PatronoController pcc) {
		this.recvedbib = recvedbib;
		this.recvpat = recvpat;

		//title and layout
		setTitle("Prendi In Prestito");
		getContentPane().setLayout(null);


		//search bar for books
		searchbar = new JTextField();
		searchbar.setBounds(10, 64, 261, 20);
		getContentPane().add(searchbar);
		searchbar.setColumns(10);


		//box to choose which strategy is wanted 
		JComboBox<String> searchStrat = new JComboBox<String>();
		searchStrat.setModel(new DefaultComboBoxModel<String>(new String[] {"per autore", "per titolo"}));
		searchStrat.setBounds(281, 63, 143, 22);
		getContentPane().add(searchStrat);



		// list to hold the book that are results of the search 
		JList<Libro> results = new JList<Libro>();
		results.setBounds(10, 95, 261, 137);
		getContentPane().add(results);
		ArrayList<Libro> resultList = new ArrayList<>();
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		results.setModel(listModel);
		for (Libro item : resultList) {
			listModel.addElement(item);
		}


		//button to call for the search method depending on the strategy chosen from the previous box
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
				ArrayList<Libro> risultati =  searchstrat2.ricerca(recvedbib.books, searchInput);

				for (Libro item : risultati) {
					if(item.isAvailable == true) {
						listModel.addElement(item);
					}

				}


			}
		});



		btnNewButton_2.setBounds(281, 92, 89, 23);
		getContentPane().add(btnNewButton_2);


		//Confirmation button that calls for the borrow method 
		JButton btnNewButton = new JButton("conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Libro selectedObject = (Libro) results.getSelectedValue();
				if (selectedObject != null) {

					try {
						pc.borrowButtonClick(selectedObject, LocalDate.now(), recvpat, recvedbib);

						if(recvpat.state != Stato.active) {
							JOptionPane.showMessageDialog(PipGUI.this, "Account state not active, refer to an admin for help!");
						}else {
							JOptionPane.showMessageDialog(PipGUI.this, "Book borrowed succefully!");
						}

						selectedObject.addPropertyChangeListener(recvpat);
						listModel.clear();

					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}


			}
		});
		btnNewButton.setBounds(335, 166, 89, 23);
		getContentPane().add(btnNewButton);


		//button to clear the search bar
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbar.setText("");
			}
		});
		btnNewButton_1.setBounds(335, 198, 89, 23);
		getContentPane().add(btnNewButton_1);


	}




}
