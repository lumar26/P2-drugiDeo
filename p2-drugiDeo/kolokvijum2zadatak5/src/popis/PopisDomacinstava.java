package popis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import popis.izuzeci.StatistikaException;

public class PopisDomacinstava {
	private List<Domacinstvo> domacinstva;

	public PopisDomacinstava() {
		domacinstva = new ArrayList<Domacinstvo>();
	}

	public void upisiDomacinstvaBezPrimanja() {
		try(BufferedWriter out = new BufferedWriter(new FileWriter("domacinstva_bez_prihoda.txt"))) {

			if (domacinstva.isEmpty()) {
				throw new StatistikaException("U listi domacinstava nema elemenata!");
			} else
				for (Domacinstvo domacinstvo : domacinstva) {
					if (domacinstvo.getMesecnaPrimanja() == 0)
						out.write(domacinstvo.getMesto() + "#" + domacinstvo.getBrojOdraslih() + "#"
								+ domacinstvo.getBrojDece() + "\n");
				}

//			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void statistikaDomacinstava() {
		int ukupnoOdraslih = 0;
		int ukupnoDece = 0;
		double ukupnaPrimanja = 0;
		for (Domacinstvo domacinstvo : domacinstva) {
			ukupnoOdraslih += domacinstvo.getBrojOdraslih();
			ukupnaPrimanja += domacinstvo.getMesecnaPrimanja();
			ukupnoDece += domacinstvo.getBrojDece();
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("izvestaj.txt"));

			out.write("Broj domacinstava: " + domacinstva.size() + "\n");
			out.write("Prosecna primanja po domacinstvu na mesecnom nivou: " + ukupnaPrimanja / domacinstva.size()  + "\n");
			out.write("Prosecan broj odraslih po domacinstvu: " + ukupnoOdraslih / domacinstva.size() + "\n");
			out.write("Prosecan broj dece po domacinstvu: " + ukupnoDece / domacinstva.size() + "\n");
			out.write("Prosecna primanja po clanu domacinstva na mesecnom nivou: "
					+ ukupnaPrimanja / (ukupnoDece + ukupnoOdraslih));

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajDomacinstvaSaTastature() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Koliko domacinstava zelite da unesete: ");
		int n = 0;
		try {
			n = Integer.parseInt(in.readLine());
			//svuda mora parsiranje
		} catch (IOException e) {
			System.out.println("Greska: " + e.getMessage());
		}

		for (int i = 0; i < n; i++) {
			Domacinstvo d = new Domacinstvo();
				try {
					System.out.println("Unesite naziv mesta: ");
					d.setMesto(in.readLine());
					System.out.println("Unesite broj odraslih osoba: ");
					d.setBrojOdraslih(in.read());
					System.out.println("Unesite broj dece: ");
					d.setBrojOdraslih(in.read());
					System.out.println("Unesite mesecna primanja: ");
					d.setMesecnaPrimanja(Double.parseDouble(in.readLine()));
				} catch (IOException e) {
					//samo jos ispisivanje pooruke
					try {
						System.out.println("Greska: " + e.getMessage());
						System.out.println("Unesite naziv mesta: ");
						d.setMesto(in.readLine());
						System.out.println("Unesite broj odraslih osoba: ");
						d.setBrojOdraslih(in.read());
						System.out.println("Unesite broj dece: ");
						d.setBrojOdraslih(in.read());
						System.out.println("Unesite mesecna primanja: ");
						d.setMesecnaPrimanja(Double.parseDouble(in.readLine()));
					} catch (NumberFormatException e1) {
						//ne radi nista
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			domacinstva.add(d);
		}

	}
}
