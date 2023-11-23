package it.unipv.ingsw.gi.admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggGUI extends JFrame{
	private Biblioteca recvdbib;
	private Admin recvdadmn;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggGUI window = new AggGUI(null,null);
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
	public AggGUI(Biblioteca recdbib,Admin recdAdmin) {
		this.recvdadmn= recdAdmin;
		this.recvdbib=recdbib;
		getContentPane().setLayout(null);
		
		JButton aggLibButton = new JButton("Agguingi Libro");
		aggLibButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgguingiLibroGUI al = new AgguingiLibroGUI(recvdbib,recvdadmn);
				al.setSize(500,400);
				al.setVisible(true);
				
			}
		});
		aggLibButton.setBounds(30, 95, 140, 55);
		getContentPane().add(aggLibButton);
		
		JButton aggPatButton = new JButton("Agguingi Patrono");
		aggPatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgguingiPatronoGUI ap = new AgguingiPatronoGUI(recvdbib,recvdadmn);
				ap.setSize(500,400);
				ap.setVisible(true);
			}
		});
		aggPatButton.setBounds(242, 95, 140, 55);
		getContentPane().add(aggPatButton);
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
