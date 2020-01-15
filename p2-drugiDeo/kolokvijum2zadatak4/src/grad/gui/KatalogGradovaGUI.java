package grad.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grad.Grad;
import grad.KatalogGradova;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KatalogGradovaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNazivGrada;
	private JLabel lblBrojStanovnika;
	private JTextField txtNazivGrada;
	private JTextField txtBrojStanovnika;
	private JButton btnDodaj;
	private JButton btnSacuvaj;
	private JButton btnObrisi;
	
	private KatalogGradova katalog = new KatalogGradova();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KatalogGradovaGUI frame = new KatalogGradovaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KatalogGradovaGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNazivGrada());
		contentPane.add(getLblBrojStanovnika());
		contentPane.add(getTxtNazivGrada());
		contentPane.add(getTxtBrojStanovnika());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnSacuvaj());
		contentPane.add(getBtnObrisi());
	}
	private JLabel getLblNazivGrada() {
		if (lblNazivGrada == null) {
			lblNazivGrada = new JLabel("Naziv Grada");
			lblNazivGrada.setBounds(91, 38, 76, 16);
		}
		return lblNazivGrada;
	}
	private JLabel getLblBrojStanovnika() {
		if (lblBrojStanovnika == null) {
			lblBrojStanovnika = new JLabel("Broj Stanovnika");
			lblBrojStanovnika.setBounds(229, 38, 99, 16);
		}
		return lblBrojStanovnika;
	}
	private JTextField getTxtNazivGrada() {
		if (txtNazivGrada == null) {
			txtNazivGrada = new JTextField();
			txtNazivGrada.setBounds(68, 67, 116, 22);
			txtNazivGrada.setColumns(10);
		}
		return txtNazivGrada;
	}
	private JTextField getTxtBrojStanovnika() {
		if (txtBrojStanovnika == null) {
			txtBrojStanovnika = new JTextField();
			txtBrojStanovnika.setBounds(222, 67, 116, 22);
			txtBrojStanovnika.setColumns(10);
		}
		return txtBrojStanovnika;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Grad grad = new Grad(txtNazivGrada.getText(), Integer.parseInt(txtBrojStanovnika.getText()));
					try {
						katalog.dodajGrad(grad);
						JOptionPane.showMessageDialog(null, "Uspesan unos grada u listu", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Neuspesan unos grada u listu", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnDodaj.setBounds(38, 136, 97, 25);
		}
		return btnDodaj;
	}
	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						katalog.upisiGradoveUKategorije();
						JOptionPane.showMessageDialog(null, "Uspesan unos gradova u fajlove", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Neuspesan unos gradova u fajlove", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSacuvaj.setBounds(159, 136, 97, 25);
		}
		return btnSacuvaj;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNazivGrada.setText(null);
					txtBrojStanovnika.setText(null);
				}
			});
			btnObrisi.setBounds(276, 136, 97, 25);
		}
		return btnObrisi;
	}
}
