package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;
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
import it.unipv.ingsw.gi.gui.PipGUI;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.ricercalibro.RicercaPerAutore;
import it.unipv.ingsw.gi.ricercalibro.RicercaPerTitolo;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.ricercalibro.SearchStrategy;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;

public class AdminpipGui extends JFrame{
	private Biblioteca recvedbib;
	private JFrame frame;
	private Admin recvdadmn;
	;
	private JTextField patSearchbar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminpipGui window = new AdminpipGui(null,null);
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
	public AdminpipGui(Biblioteca recvedbib,Admin recvadmn) {
		this.recvedbib = recvedbib;
		this.recvdadmn = recvadmn;



		setTitle("Prendi In Prestito (Admin)");
		getContentPane().setLayout(null);

		JTextField searchbar = new JTextField();
		searchbar.setBounds(10, 82, 261, 20);
		getContentPane().add(searchbar);
		searchbar.setColumns(10);





		JComboBox<String> searchStrat = new JComboBox<String>();
		searchStrat.setModel(new DefaultComboBoxModel<String>(new String[] {"per autore", "per titolo"}));
		searchStrat.setBounds(281, 81, 143, 22);
		getContentPane().add(searchStrat);




		JList<Libro> results = new JList<Libro>();

		results.setBounds(10, 113, 261, 137);
		getContentPane().add(results);

		ArrayList<Libro> resultList = new ArrayList<>();
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		results.setModel(listModel);

		for (Libro item : resultList) {
			listModel.addElement(item);
		}

		patSearchbar = new JTextField();
		patSearchbar.setBounds(10, 11, 261, 20);
		getContentPane().add(patSearchbar);
		patSearchbar.setColumns(10);
		
		
		
		JList<Patrono> patList = new JList<Patrono>();
		patList.setBounds(10, 37, 261, 34);
		getContentPane().add(patList);
		

		
		DefaultListModel<Patrono> patlistModel = new DefaultListModel<Patrono>();
		patList.setModel(patlistModel);
		
		
		
		
		
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
		
		
		
		
		
		
		
		

		JButton btnNewButton_2 = new JButton("cerca");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchT = (String) searchStrat.getSelectedItem();
				String searchInput = searchbar.getText();

				SearchStrategy<String> searchstrat;
				if ("per titolo".equals(searchT)) {
					searchstrat = new RicercaPerTitolo();
				}
				else if ("per autore".equals(searchT)) {
					searchstrat = new RicercaPerAutore();

				} else {
					return;
				}

				ArrayList<Libro> risultati = (ArrayList<Libro>) searchstrat.ricerca(recvedbib.books, searchInput);

				for (Libro item : risultati) {
					if(item.isAvailable == true) {
						listModel.addElement(item);
					}

				}


			}
		});

		

		btnNewButton_2.setBounds(281, 114, 89, 23);
		getContentPane().add(btnNewButton_2);
		


		JButton btnNewButton = new JButton("conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Patrono recvdpat = (Patrono) patList.getSelectedValue();
				Libro selectedObject = (Libro) results.getSelectedValue();
				if (selectedObject != null && recvdpat != null) {

					try {
						
						recvadmn.borrowbook(selectedObject, LocalDate.now(), recvdpat, recvedbib);
						JOptionPane.showMessageDialog(AdminpipGui.this, "book borrowed succefully!");

					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}


			}
		});
		btnNewButton.setBounds(335, 193, 89, 23);
		getContentPane().add(btnNewButton);


		initialize();

		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbar.setText("");
				
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton clearListbutton = new JButton("clear");
		clearListbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patlistModel.clear();
			}
		});
		clearListbutton.setBounds(281, 37, 89, 23);
		getContentPane().add(clearListbutton);
		
		

		
		
		

	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
