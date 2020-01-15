package autobuska_stanica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import autobuska_stanica.AutobuskaStanica;
import autobuska_stanica.Polazak;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AutobuskaStanicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnos;
	private JLabel lblDestinacija;
	private JLabel lblPolazak;
	private JLabel lblBrojslobodnihmesta;
	private JLabel lblRezervacija;
	private JLabel lblDestinacija_1;
	private JLabel lblBrojKarata;
	private JButton btnRezervisi;
	private JTextField txtDestinacija;
	private JTextField txtPolazakDan;
	private JTextField txtPolazakMesec;
	private JTextField txtPolazakGodina;
	private JLabel label;
	private JLabel label_1;
	private JTextField txtSlobodnaMesta;
	private JTextField txtDestinacijaRezervacija;
	private JTextField txtBrojKarata;
	private JButton btnDodaj;
	private JButton btnObrisi;
	
	private AutobuskaStanica stanica = new AutobuskaStanica();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutobuskaStanicaGUI frame = new AutobuskaStanicaGUI();
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
	public AutobuskaStanicaGUI() {
		setTitle("Autobuska Stanica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUnos());
		contentPane.add(getLblDestinacija());
		contentPane.add(getLblPolazak());
		contentPane.add(getLblBrojslobodnihmesta());
		contentPane.add(getLblRezervacija());
		contentPane.add(getLblDestinacija_1());
		contentPane.add(getLblBrojKarata());
		contentPane.add(getBtnRezervisi());
		contentPane.add(getTxtDestinacija());
		contentPane.add(getTxtPolazakDan());
		contentPane.add(getTxtPolazakMesec());
		contentPane.add(getTxtPolazakGodina());
		contentPane.add(getLabel());
		contentPane.add(getLabel_1());
		contentPane.add(getTxtSlobodnaMesta());
		contentPane.add(getTxtDestinacijaRezervacija());
		contentPane.add(getTxtBrojKarata());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnObrisi());
	}
	private JLabel getLblUnos() {
		if (lblUnos == null) {
			lblUnos = new JLabel("UNOS");
			lblUnos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUnos.setBounds(53, 50, 56, 16);
		}
		return lblUnos;
	}
	private JLabel getLblDestinacija() {
		if (lblDestinacija == null) {
			lblDestinacija = new JLabel("Destinacija");
			lblDestinacija.setBounds(53, 101, 85, 16);
		}
		return lblDestinacija;
	}
	private JLabel getLblPolazak() {
		if (lblPolazak == null) {
			lblPolazak = new JLabel("Polazak (d/m/g):");
			lblPolazak.setBounds(53, 138, 97, 16);
		}
		return lblPolazak;
	}
	private JLabel getLblBrojslobodnihmesta() {
		if (lblBrojslobodnihmesta == null) {
			lblBrojslobodnihmesta = new JLabel("Broj Slobodnih Mesta");
			lblBrojslobodnihmesta.setBounds(53, 175, 129, 16);
		}
		return lblBrojslobodnihmesta;
	}
	private JLabel getLblRezervacija() {
		if (lblRezervacija == null) {
			lblRezervacija = new JLabel("REZERVACIJA");
			lblRezervacija.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRezervacija.setBounds(53, 222, 129, 16);
		}
		return lblRezervacija;
	}
	private JLabel getLblDestinacija_1() {
		if (lblDestinacija_1 == null) {
			lblDestinacija_1 = new JLabel("Destinacija");
			lblDestinacija_1.setBounds(53, 268, 97, 16);
		}
		return lblDestinacija_1;
	}
	private JLabel getLblBrojKarata() {
		if (lblBrojKarata == null) {
			lblBrojKarata = new JLabel("Broj karata");
			lblBrojKarata.setBounds(53, 305, 85, 16);
		}
		return lblBrojKarata;
	}
	private JButton getBtnRezervisi() {
		if (btnRezervisi == null) {
			btnRezervisi = new JButton("Rezervisi");
			btnRezervisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						stanica.rezervisiKarte(txtDestinacijaRezervacija.getText(), Integer.parseInt(txtBrojKarata.getText()));
						JOptionPane.showMessageDialog(null, "Karte su uspesno rezervisane", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Karte nisu uspesno rezervisane", "Greska", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			btnRezervisi.setBounds(53, 360, 97, 25);
		}
		return btnRezervisi;
	}
	private JTextField getTxtDestinacija() {
		if (txtDestinacija == null) {
			txtDestinacija = new JTextField();
			txtDestinacija.setBounds(240, 98, 132, 22);
			txtDestinacija.setColumns(10);
		}
		return txtDestinacija;
	}
	private JTextField getTxtPolazakDan() {
		if (txtPolazakDan == null) {
			txtPolazakDan = new JTextField();
			txtPolazakDan.setBounds(238, 135, 22, 22);
			txtPolazakDan.setColumns(10);
		}
		return txtPolazakDan;
	}
	private JTextField getTxtPolazakMesec() {
		if (txtPolazakMesec == null) {
			txtPolazakMesec = new JTextField();
			txtPolazakMesec.setBounds(278, 135, 22, 22);
			txtPolazakMesec.setColumns(10);
		}
		return txtPolazakMesec;
	}
	private JTextField getTxtPolazakGodina() {
		if (txtPolazakGodina == null) {
			txtPolazakGodina = new JTextField();
			txtPolazakGodina.setBounds(324, 135, 48, 22);
			txtPolazakGodina.setColumns(10);
		}
		return txtPolazakGodina;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("/");
			label.setBounds(265, 138, 12, 16);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("/");
			label_1.setBounds(312, 138, 12, 16);
		}
		return label_1;
	}
	private JTextField getTxtSlobodnaMesta() {
		if (txtSlobodnaMesta == null) {
			txtSlobodnaMesta = new JTextField();
			txtSlobodnaMesta.setBounds(240, 183, 56, 22);
			txtSlobodnaMesta.setColumns(10);
		}
		return txtSlobodnaMesta;
	}
	private JTextField getTxtDestinacijaRezervacija() {
		if (txtDestinacijaRezervacija == null) {
			txtDestinacijaRezervacija = new JTextField();
			txtDestinacijaRezervacija.setBounds(237, 265, 116, 22);
			txtDestinacijaRezervacija.setColumns(10);
		}
		return txtDestinacijaRezervacija;
	}
	private JTextField getTxtBrojKarata() {
		if (txtBrojKarata == null) {
			txtBrojKarata = new JTextField();
			txtBrojKarata.setBounds(237, 302, 34, 22);
			txtBrojKarata.setColumns(10);
		}
		return txtBrojKarata;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Polazak p = new Polazak(txtDestinacija.getText(), Integer.parseInt(txtSlobodnaMesta.getText()));
						stanica.getPolasci().add(p);
						JOptionPane.showMessageDialog(null, "Novi polazak je dodat u listu", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Novi polazak nije dodat u listu", "Greska", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			btnDodaj.setBounds(404, 119, 97, 25);
		}
		return btnDodaj;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtDestinacija.setText(null);
					txtPolazakDan.setText(null);
					txtPolazakGodina.setText(null);
					txtPolazakMesec.setText(null);
					txtSlobodnaMesta.setText(null);
				}
			});
			btnObrisi.setBounds(404, 171, 97, 25);
		}
		return btnObrisi;
	}
}
