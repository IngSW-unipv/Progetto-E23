package it.unipv.ingsw.gi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.mysql.cj.protocol.a.result.BinaryBufferRow;

import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.users.Patrono;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatrGUI extends JFrame{

	private JFrame frame;
	protected Biblioteca recvedbib;
	protected Patrono recvpat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatrGUI window = new PatrGUI(null, null);
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
	public PatrGUI(Biblioteca recvedbib ,Patrono recvpat) {
		this.recvedbib = recvedbib;
		this.recvpat = recvpat;
		setTitle("Patrono ");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Prendi in prestito");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PipGUI newpip =	new PipGUI(recvedbib,recvpat);
				newpip.setVisible(true);
				newpip.setSize(500, 400);
				
			}
		});
		btnNewButton.setBounds(10, 71, 134, 23);
		getContentPane().add(btnNewButton);
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
