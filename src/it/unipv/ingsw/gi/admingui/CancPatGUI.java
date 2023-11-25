package it.unipv.ingsw.gi.admingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.ricercalibro.RicercaperID;
import it.unipv.ingsw.gi.users.Admin;
import it.unipv.ingsw.gi.users.Patrono;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CancPatGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Biblioteca recvdbibb;
	private Admin recvdadmnn;

	private JTextField patSearchbar;



	/**
	 * Create the application.
	 */
	public CancPatGUI(Biblioteca recvdbib,Admin recvdadmn) {
		this.recvdadmnn = recvdadmn;
		this.recvdbibb = recvdbib;
		// title and layout
		setTitle("Cancella Patrono");
		getContentPane().setLayout(null);



		//patron search bar
		patSearchbar = new JTextField();
		patSearchbar.setBounds(10, 11, 261, 20);
		getContentPane().add(patSearchbar);
		patSearchbar.setColumns(10);


		// list to hoold the result of the search
		JList<Patrono> patList = new JList<Patrono>();
		patList.setBounds(10, 37, 261, 65);
		getContentPane().add(patList);
		DefaultListModel<Patrono> patlistModel = new DefaultListModel<Patrono>();
		patList.setModel(patlistModel);




		//button to call the search function
		JButton cercapatButton = new JButton("Cerca");
		cercapatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				patlistModel.clear();
				RicercaperID rpd = new RicercaperID();
				ArrayList<Patrono> list = new ArrayList<>();
				for(Patrono p : recvdbibb.patrons) {
					list.add(p);
				}

				list = rpd.ricercaPat(list, Integer.parseInt(patSearchbar.getText()));

				for(Patrono pat : list) {
					patlistModel.addElement(pat);
				}}
		});

		cercapatButton.setBounds(281, 10, 89, 23);
		getContentPane().add(cercapatButton);


		//button to call the delete patron function
		JButton conferma = new JButton("Conferma");
		conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recvdadmnn.canPatrono(patList.getSelectedValue(), recvdbibb);
					JOptionPane.showMessageDialog(CancPatGUI.this, "patron deleted succefully!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		conferma.setBounds(314, 227, 110, 23);
		getContentPane().add(conferma);



	}

}
