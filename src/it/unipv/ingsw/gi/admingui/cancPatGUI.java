package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;
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

public class cancPatGUI extends JFrame{
	private Biblioteca recvdbib;
	private Admin recvdadmn;
	private JFrame frame;
	private JTextField textField;
	private JTextField patSearchbar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancPatGUI window = new cancPatGUI(null,null);
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
	public cancPatGUI(Biblioteca recvdbib,Admin recvdadmn) {
		this.recvdadmn = recvdadmn;
		this.recvdbib = recvdbib;
		
		setTitle("Cancella Patrono");
		getContentPane().setLayout(null);
		
		
		
		
		
		
		patSearchbar = new JTextField();
		patSearchbar.setBounds(10, 11, 261, 20);
		getContentPane().add(patSearchbar);
		patSearchbar.setColumns(10);
		
		
		
		JList<Patrono> patList = new JList<Patrono>();
		patList.setBounds(10, 37, 261, 65);
		getContentPane().add(patList);
		

		
		DefaultListModel<Patrono> patlistModel = new DefaultListModel<Patrono>();
		patList.setModel(patlistModel);
		
		
		
		
		
		JButton cercapatButton = new JButton("Cerca");
		cercapatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				RicercaperID rpd = new RicercaperID();
				ArrayList<Patrono> list = new ArrayList<>();
				for(Patrono p : recvdbib.patrons) {
					list.add(p);
				}
				
				list = rpd.ricercaPat(list, Integer.parseInt(patSearchbar.getText()));

				for(Patrono pat : list) {
					patlistModel.addElement(pat);
				}}
		});

		cercapatButton.setBounds(281, 10, 89, 23);
		getContentPane().add(cercapatButton);
		
		JButton conferma = new JButton("Conferma");
		conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recvdadmn.canPatrono(patList.getSelectedValue(), recvdbib);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		conferma.setBounds(314, 227, 110, 23);
		getContentPane().add(conferma);

		
		
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
