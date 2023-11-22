package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.unipv.ingsw.gi.books.Libro;
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
					RestitLibGUI window = new RestitLibGUI(null,null);
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
	public RestitLibGUI(Biblioteca biblioteca,Admin recvAdmin) {
		this.recvedbib = biblioteca;
		this.recvedadm = recvAdmin;
		
		
		setTitle("Restituire Libro");
		getContentPane().setLayout(null);
		
		booksearchfield = new JTextField();
		booksearchfield.setBounds(10, 11, 292, 20);
		getContentPane().add(booksearchfield);
		booksearchfield.setColumns(10);
		
		JList bookresultslist = new JList();
		bookresultslist.setBounds(10, 47, 292, 105);
		getContentPane().add(bookresultslist);
		
		
		ArrayList<PrendeInPrestito> resultList = new ArrayList<>();
		DefaultListModel<PrendeInPrestito> listModel = new DefaultListModel<PrendeInPrestito>();
		bookresultslist.setModel(listModel);

		for (PrendeInPrestito item : resultList) {
			listModel.addElement(item);
		}
		
		
		
		
		
		
		
		JButton patsearchbutton = new JButton("cerca");
		patsearchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RicercaperID rpd = new RicercaperID();
				ArrayList<PrendeInPrestito> list = new ArrayList<>();
				for(PrendeInPrestito p : recvedbib.listPrestiti) {
					list.add(p);
				}
				rpd.ricerca(list, Integer.parseInt(booksearchfield.getText()));
				
				for (PrendeInPrestito item : list) {
					listModel.addElement(item);
				}
				
			}
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
				Patrono selectedpat = null;
				PrendeInPrestito selectedpren = null;
				selectedpren =(PrendeInPrestito) bookresultslist.getSelectedValue();
				selectedpat = selectedpren.getUtente();
				for (PrendeInPrestito myObject : recvedbib.listPrestiti) {
		            if (myObject.getUtente() == bookresultslist.getSelectedValue() ) {
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
