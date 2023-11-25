package it.unipv.ingsw.gi.admingui;



import javax.swing.JFrame;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RestitLibGUI extends JFrame{
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	protected Biblioteca recvedbibb;
	private JTextField booksearchfield;
	protected Admin recvedadmm;



	/**
	 * Create the application.
	 */
	public RestitLibGUI(Biblioteca biblioteca,Admin recvAdmin) {
		this.recvedbibb = biblioteca;
		this.recvedadmm = recvAdmin;

		// title and layout
		setTitle("Restituire Libro");
		getContentPane().setLayout(null);

		//search bar for book
		booksearchfield = new JTextField();
		booksearchfield.setBounds(10, 11, 292, 20);
		getContentPane().add(booksearchfield);
		booksearchfield.setColumns(10);


		//list to hold the result of the search
		JList<PrendeInPrestito> bookresultslist = new JList<PrendeInPrestito>();
		bookresultslist.setBounds(10, 47, 292, 105);
		getContentPane().add(bookresultslist);
		ArrayList<PrendeInPrestito> resultList = new ArrayList<>();
		DefaultListModel<PrendeInPrestito> listModel = new DefaultListModel<PrendeInPrestito>();
		bookresultslist.setModel(listModel);

		for (PrendeInPrestito item : resultList) {
			listModel.addElement(item);
		}


		// button to call the search method
		JButton patsearchbutton = new JButton("cerca");
		patsearchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				RicercaperID rpd = new RicercaperID();
				ArrayList<PrendeInPrestito> list = new ArrayList<>();
				for(PrendeInPrestito p : recvedbibb.listPrestiti) {
					list.add(p);
				}
				rpd.ricerca2(list, Integer.parseInt(booksearchfield.getText()));

				for (PrendeInPrestito item : list) {
					listModel.addElement(item);
				}

			}
		});

		patsearchbutton.setBounds(312, 10, 89, 23);
		getContentPane().add(patsearchbutton);


		//button to clear the search bar
		JButton bclearbutton = new JButton("clear");
		bclearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booksearchfield.setText("");
			}
		});
		bclearbutton.setBounds(312, 44, 89, 23);
		getContentPane().add(bclearbutton);


		//button for the confirmation and return method
		JButton btnNewButton_3 = new JButton("Conferma");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patrono selectedpat = null;
				PrendeInPrestito selectedpren = null;
				selectedpren =(PrendeInPrestito) bookresultslist.getSelectedValue();
				selectedpat = selectedpren.getUtente();
				for (PrendeInPrestito myObject : recvedbibb.listPrestiti) {
					if (myObject == bookresultslist.getSelectedValue() ) {
						selectedpat = myObject.getUtente();
						break; // Exit the loop once the desired object is found
					}
				}
				try {
					recvAdmin.returnbook( (PrendeInPrestito) bookresultslist.getSelectedValue(), biblioteca, selectedpat);
					JOptionPane.showMessageDialog(RestitLibGUI.this, "book returned!");
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(312, 194, 99, 41);
		getContentPane().add(btnNewButton_3);
	}



}
