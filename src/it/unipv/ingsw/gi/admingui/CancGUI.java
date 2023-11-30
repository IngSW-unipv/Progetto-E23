package it.unipv.ingsw.gi.admingui;


import javax.swing.JFrame;
import it.unipv.ingsw.gi.library.Biblioteca;
import it.unipv.ingsw.gi.posti.PrenotaPosti;
import it.unipv.ingsw.gi.users.Admin;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Biblioteca recvdBibb;
	private Admin recvdadmnn;



	/**
	 * Creating the cancel function selection interface
	 */
	public CancGUI(Biblioteca recvBib,Admin recvdadmn) {
		setTitle("cancel selection");
		this.recvdadmnn= recvdadmn;
		this.recvdBibb = recvBib;

		new JFrame();
		setBounds(100, 100, 469, 309);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		//button to open the delete preservation interface
		JButton btnNewButton = new JButton("Cancella Prenotazione");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrenotaPosti ps = new PrenotaPosti(10);
				CancellaPrenotazionePostoGUI cpg = new CancellaPrenotazionePostoGUI(ps);
				cpg.setSize(500,400);
				cpg.setVisible(true);
			}
		});
		btnNewButton.setBounds(120, 105, 164, 62);
		getContentPane().add(btnNewButton);

		//button to open the delete book interface
		JButton btnCancellaLibro = new JButton("Cancella Libro");
		btnCancellaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancellaLibroGUI clg = new CancellaLibroGUI(recvdBibb, recvdadmnn);
				clg.setSize(500,400);
				clg.setVisible(true);
			}
		});
		btnCancellaLibro.setBounds(118, 178, 166, 62);
		getContentPane().add(btnCancellaLibro);


		//button to delete the delete patron interface
		JButton btnCancellaPatrono = new JButton("Cancella Patrono");
		btnCancellaPatrono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancPatGUI cpg = new CancPatGUI(recvdBibb, recvdadmnn);
				cpg.setSize(500,400);
				cpg.setVisible(true);
			}
		});
		btnCancellaPatrono.setBounds(120, 26, 164, 68);
		getContentPane().add(btnCancellaPatrono);

	}



}
