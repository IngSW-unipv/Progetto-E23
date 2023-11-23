package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import it.unipv.ingsw.gi.books.Libro;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.library.PrendeInPrestito;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;

public class CancellaLibroGUI extends JFrame{
	
	protected Biblioteca recvedbib;
	private JFrame frame;
	private JTextField booksearchfield;
	protected Admin recvedadm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancellaLibroGUI window = new CancellaLibroGUI(null,null);
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
	public CancellaLibroGUI(Biblioteca biblioteca,Admin recvAdmin) {
		this.recvedbib = biblioteca;
		this.recvedadm = recvAdmin;
		
		
		setTitle("Cancella Libro");
		getContentPane().setLayout(null);
		
		booksearchfield = new JTextField();
		booksearchfield.setBounds(10, 11, 292, 20);
		getContentPane().add(booksearchfield);
		booksearchfield.setColumns(10);
		
		JList<Libro> bookresultslist = new JList<Libro>();
		bookresultslist.setBounds(10, 47, 292, 105);
		getContentPane().add(bookresultslist);
		
		
		ArrayList<Libro> resultList = new ArrayList<>();
		DefaultListModel<Libro> listModel = new DefaultListModel<Libro>();
		bookresultslist.setModel(listModel);

		
		
		
		JButton patsearchbutton = new JButton("cerca");
		patsearchbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RicercaperID rpd = new RicercaperID();
				ArrayList<Libro> list = new ArrayList<>();
				for(Libro p : recvedbib.books) {
					list.add(p);
				}
			 list = rpd.ricerca2(list, Integer.parseInt(booksearchfield.getText()));
				
			 for(Libro lib : list) {
				listModel.addElement(lib);
			}}
		});
		
		patsearchbutton.setBounds(312, 10, 89, 23);
		getContentPane().add(patsearchbutton);
		
		JButton patclearbutton = new JButton("clear");
		patclearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booksearchfield.setText("");
			}
		});
		patclearbutton.setBounds(312, 44, 89, 23);
		getContentPane().add(patclearbutton);
		
		JButton btnNewButton_3 = new JButton("Conferma");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					recvAdmin.canLibro((Libro) bookresultslist.getSelectedValue(), biblioteca);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		btnNewButton_3.setBounds(335, 208, 89, 23);
		getContentPane().add(btnNewButton_3);
		initialize();
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
