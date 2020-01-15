package klinika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klinika.osoblje.Lekar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class KlinikaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelWest;
	private JPanel panelSouth;
	private JLabel lblImeIPrezime;
	private JTextField txtImeIPrezime;
	private JLabel lblDatumZaposlenja;
	private JTextField txtDatum;
	private JLabel lblSpecijalnost;
	private JComboBox comboBox;
	private JButton btnUnesi;
	private JButton btnPrikazi;
	private JButton btnSacuvaj;
	private JTextArea textArea;

	private List<Lekar> lekari = new ArrayList<Lekar>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KlinikaGUI frame = new KlinikaGUI();
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
	public KlinikaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelWest(), BorderLayout.WEST);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
		contentPane.add(getTextArea(), BorderLayout.CENTER);
	}

	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setPreferredSize(new Dimension(120, 40));
			panelWest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelWest.add(getLblImeIPrezime());
			panelWest.add(getTxtImeIPrezime());
			panelWest.add(getLblDatumZaposlenja());
			panelWest.add(getTxtDatum());
			panelWest.add(getLblSpecijalnost());
			panelWest.add(getComboBox());
		}
		return panelWest;
	}

	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setPreferredSize(new Dimension(20, 120));
			panelSouth.add(getBtnUnesi());
			panelSouth.add(getBtnPrikazi());
			panelSouth.add(getBtnSacuvaj());
		}
		return panelSouth;
	}

	private JLabel getLblImeIPrezime() {
		if (lblImeIPrezime == null) {
			lblImeIPrezime = new JLabel("Ime i Prezime");
		}
		return lblImeIPrezime;
	}

	private JTextField getTxtImeIPrezime() {
		if (txtImeIPrezime == null) {
			txtImeIPrezime = new JTextField();
			txtImeIPrezime.setColumns(10);
		}
		return txtImeIPrezime;
	}

	private JLabel getLblDatumZaposlenja() {
		if (lblDatumZaposlenja == null) {
			lblDatumZaposlenja = new JLabel("Datum Zaposlenja");
		}
		return lblDatumZaposlenja;
	}

	private JTextField getTxtDatum() {
		if (txtDatum == null) {
			txtDatum = new JTextField();
			txtDatum.setColumns(10);
		}
		return txtDatum;
	}

	private JLabel getLblSpecijalnost() {
		if (lblSpecijalnost == null) {
			lblSpecijalnost = new JLabel("Specijalnost");
		}
		return lblSpecijalnost;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("Oftamolog");
			comboBox.addItem("Kardiolog");
			comboBox.addItem("Opsta praksa");
		}
		return comboBox;
	}

	private JButton getBtnUnesi() {
		if (btnUnesi == null) {
			btnUnesi = new JButton("Unesi");
			btnUnesi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DateFormat df = new SimpleDateFormat("dd MM yyyy");
					Date date = new Date();
					try {
						date = df.parse(txtDatum.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					GregorianCalendar datum = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
					Lekar l = new Lekar(txtImeIPrezime.getText(), datum, comboBox.getSelectedItem().toString());
					if(!jeUListi(l))
						lekari.add(l);
				}
			});
		}
		return btnUnesi;
	}

	private JButton getBtnPrikazi() {
		if (btnPrikazi == null) {
			btnPrikazi = new JButton("Prikazi");
			btnPrikazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (int i = lekari.size(); i < 0; i++) {
						textArea.append(lekari.get(i).toString() + "\n");
					}
				}
			});
		}
		return btnPrikazi;
	}

	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("izvestaj.out")));
						
						for (Lekar lekar : lekari) {
							if(imaViseSpecijalizacija(lekar)) out.writeObject(lekar);
						}
						
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		return btnSacuvaj;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private boolean jeUListi(Lekar lekar) {
		for (Lekar l : lekari) {
			if (l.equals(lekar))
				return true;
		}
		return false;
	}
	
	private boolean imaViseSpecijalizacija(Lekar lekar) {
		int brojac= 0;
		String specijalnost = "";
		for (Lekar l : lekari) {
			if(l.getImePrezime().equals(lekar.getImePrezime()))
				brojac++;
			if(brojac > 0 && !(l.getSpecijalnost().equals(lekar.getSpecijalnost())))
				return true;
		}
		return false;
	}
}
