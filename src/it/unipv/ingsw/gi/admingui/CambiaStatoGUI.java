package it.unipv.ingsw.gi.admingui;



import javax.swing.JFrame;
import javax.swing.JTextField;

import it.unipv.ingsw.gi.controllers.AdminController;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import it.unipv.ingsw.gi.users.Stato;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class CambiaStatoGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin recvdadmn;
	private Biblioteca recvdbib;
	protected AdminController admc = new AdminController(recvdadmn);
	private JTextField patSearchfield;


	/**
	 * Create the application.
	 */
	public CambiaStatoGUI(Biblioteca recvedbib,Admin recvdadmin) {
		getContentPane().setLayout(null);

		this.recvdadmn = recvdadmin;
		this.recvdbib = recvedbib;



		// search bar for patrons
		patSearchfield = new JTextField();
		patSearchfield.setBounds(10, 32, 297, 20);
		getContentPane().add(patSearchfield);
		patSearchfield.setColumns(10);

		//list to hold the result of the search 
		JList<Patrono> patronResultlist = new JList<Patrono>();
		patronResultlist.setBounds(10, 63, 297, 124);
		getContentPane().add(patronResultlist);


		DefaultListModel<Patrono> patlistModel = new DefaultListModel<>();
		patronResultlist.setModel(patlistModel);

		for(Patrono pat : recvdbib.patrons) {
			patlistModel.addElement(pat);
		}


		//button to call the search function
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




		// list to hold the possible states to choose from
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



		//button for confirmation
		JButton btnNewButton_1 = new JButton("Conferma");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admc.cambiaStatoButtonClick(patronResultlist.getSelectedValue(), stateList.getSelectedValue(),recvdadmin);
				 	JOptionPane.showMessageDialog(CambiaStatoGUI.this, "patron  state changed succefully!") ;
			 	} catch (Exception e1) {

			 		e1.printStackTrace();
		 		}
		 	}
	 	});
		btnNewButton_1.setBounds(317, 208, 107, 42);
		getContentPane().add(btnNewButton_1);

	}




}
