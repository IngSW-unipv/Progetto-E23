package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class CambiaStatoGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin;
	private Biblioteca recvdbib;
	private JFrame frame;
	private JTextField patSearchfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiaStatoGUI window = new CambiaStatoGUI(null,null);
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
	public CambiaStatoGUI(Biblioteca recvdbib,Admin recvdadmin) {
		getContentPane().setLayout(null);
		
		
		this.recvdbib=recvdbib;
		
		patSearchfield = new JTextField();
		patSearchfield.setBounds(10, 32, 297, 20);
		getContentPane().add(patSearchfield);
		patSearchfield.setColumns(10);
		
		
		
		

		JList<Patrono> patronResultlist = new JList<Patrono>();
		patronResultlist.setBounds(10, 63, 297, 124);
		getContentPane().add(patronResultlist);
		
		
		DefaultListModel<Patrono> patlistModel = new DefaultListModel<>();
		patronResultlist.setModel(patlistModel);
		
		for(Patrono pat : recvdbib.patrons) {
			patlistModel.addElement(pat);
		}
		
		
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Patrono pat : recvdbib.patrons ) {
					
					if (pat.getPatronID() == Integer.parseInt(patSearchfield.getText())) {
						patlistModel.clear();
						patlistModel.addElement(pat);
					}
					
				}
				
				
			}
		});
		btnNewButton.setBounds(317, 31, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		
		
		
		JList<Stato> stateList = new JList<Stato>();
		stateList.setBounds(10, 198, 297, 52);
		getContentPane().add(stateList);
		
		ArrayList<Stato> resList = new ArrayList<>();
		DefaultListModel<Stato> listModel = new DefaultListModel<Stato>();
		stateList.setModel(listModel);
		resList.add(Stato.active);
		resList.add(Stato.frozen);
		resList.add(Stato.closed);
		for(Stato state : resList) {
			listModel.addElement(state);
		}
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Conferma");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recvdadmin.cambiaStato(patronResultlist.getSelectedValue(), stateList.getSelectedValue());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(317, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
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
