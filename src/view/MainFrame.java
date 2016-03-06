package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

import db.DAO;
import db.DbDataAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea notestTextArea;
	private JButton btnVider;
	private JButton buttonCrypter;
	private JButton btnDecrypter;
	private JButton btnEnregistrer;
	
	DAO dbDao = new DbDataAccess();

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		notestTextArea = new JTextArea();
		try {
			notestTextArea.setText(dbDao.loadNote().getNote());
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oups something wrong happened :(");
		}
		contentPane.add(notestTextArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnVider = new JButton("Vider");
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				notestTextArea.setText("");
			}
		});
		panel.add(btnVider);
		
		buttonCrypter = new JButton("crypter");
		panel.add(buttonCrypter);
		
		 btnDecrypter = new JButton("Decrypter");
		panel.add(btnDecrypter);
		
		 btnEnregistrer = new JButton("Enregistrer");
		 btnEnregistrer.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		try {
					dbDao.save(notestTextArea.getText().toString());
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Oups something wrong happened :(");
				}
		 	}
		 });
		panel.add(btnEnregistrer);
	}

}
